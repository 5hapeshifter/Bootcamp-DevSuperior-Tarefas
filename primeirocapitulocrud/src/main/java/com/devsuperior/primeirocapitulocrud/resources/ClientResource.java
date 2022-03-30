package com.devsuperior.primeirocapitulocrud.resources;

import com.devsuperior.primeirocapitulocrud.dtos.ClientDTO;
import com.devsuperior.primeirocapitulocrud.entities.Client;
import com.devsuperior.primeirocapitulocrud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return ResponseEntity.ok().body(clientService.findAllPaged(pageRequest));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> findById(@PathVariable(name = "clientId") Long id) {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDTO);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable(value = "clientId") Long id,
                                                  @RequestBody ClientDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
        return ResponseEntity.ok().body(clientDTO);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable(value = "clientId") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}