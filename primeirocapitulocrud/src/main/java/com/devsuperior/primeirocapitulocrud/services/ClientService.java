package com.devsuperior.primeirocapitulocrud.services;

import com.devsuperior.primeirocapitulocrud.dtos.ClientDTO;
import com.devsuperior.primeirocapitulocrud.entities.Client;
import com.devsuperior.primeirocapitulocrud.repositories.ClientRepository;
import com.devsuperior.primeirocapitulocrud.services.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientDTO> findAllClients() {
        List<ClientDTO> list = new ArrayList<>();
        for (Client client : clientRepository.findAll()){
            list.add(new ClientDTO(client));
        }
        return list;
    }
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() ->new ClientNotFoundException("Entity not found."));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client();
        copyDtoToEntity(client, clientDTO);
        clientRepository.save(client);
        clientDTO.setId(client.getId());
        return clientDTO;
    }
    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        try {
            Client client = clientRepository.findById(id).get();
            copyDtoToEntity(client, clientDTO);
            clientRepository.save(client);
            clientDTO.setId(client.getId());
            return clientDTO;
        } catch (NoSuchElementException e){
            throw new ClientNotFoundException("Id not found " + id);
        }

    }

    private void copyDtoToEntity(Client client, ClientDTO clientDTO) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(clientDTO.getBirthdate());
            client.setBirthdate(date.toInstant());
            client.setName(clientDTO.getName());
            client.setCpf(clientDTO.getCpf());
            client.setIncome(clientDTO.getIncome());
            client.setChildren(clientDTO.getChildren());

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(Long id) {
        try {
        clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ClientNotFoundException("Id not found " + id);
        }
    }
}
