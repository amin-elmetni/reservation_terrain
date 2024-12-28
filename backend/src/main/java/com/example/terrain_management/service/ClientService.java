package com.example.terrain_management.service;
import com.example.terrain_management.entity.*;

import com.example.terrain_management.dto.ClientDto;
import com.example.terrain_management.entity.Client;
import com.example.terrain_management.mapper.ClientMapper;
import com.example.terrain_management.repository.ClientRepository;
import com.example.terrain_management.repository.UtilisateurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, UtilisateurRepository utilisateurRepository) {
        this.clientRepository = clientRepository;
        this.clientMapper = new ClientMapper(utilisateurRepository);
    }

    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto getClientById(Integer id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toDto(client);
    }

    public ClientDto getClientByUtilisateurId(Integer utilisateurId) {
        Client client = clientRepository.findByUtilisateurId(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return ClientMapper.toDto(client);
    }


    public Client createClient(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        return clientRepository.save(client);
    }

    public ClientDto updateClient(Integer id, ClientDto clientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.setNomOrganisation(clientDto.getNomOrganisation());
        client.setTypeClient(clientDto.getTypeClient());
        return ClientMapper.toDto(clientRepository.save(client));
    }

    public void deleteClient(Integer id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id);
    }
}
