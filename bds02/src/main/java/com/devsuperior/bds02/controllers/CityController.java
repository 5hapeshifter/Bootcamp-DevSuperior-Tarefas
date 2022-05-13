package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.services.CityService;
import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        var cidades = service.findALl();
        return ResponseEntity.ok(cidades);
    }

    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO cityDTO) {
        var entity = service.save(cityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) throws NotFoundException, BadHttpRequest {

//        try {
            service.delete(id);
//        } catch (DataIntegrityViolationException e) {
//            throw new BadHttpRequest();
//        } catch (EmptyResultDataAccessException e){
//            throw new NotFoundException(e.getMessage());
//        }
        return ResponseEntity.noContent().build();
    }

}
