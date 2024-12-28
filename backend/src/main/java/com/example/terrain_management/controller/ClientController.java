package com.example.terrain_management.controller;


import com.example.terrain_management.dto.ClientDto;
import com.example.terrain_management.entity.Client;
import com.example.terrain_management.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.createClient(clientDto));
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<ClientDto> getClientByUtilisateurId(@PathVariable Integer utilisateurId) {
        return ResponseEntity.ok(clientService.getClientByUtilisateurId(utilisateurId));
    }



    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Integer id,
                                                  @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.updateClient(id, clientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
