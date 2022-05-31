package com.devsuperior.bds04.controllers;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAllCitiesPaged(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        List<CityDTO> result = service.findAll(pageRequest);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CityDTO> insertCity(@Valid @RequestBody CityDTO dto) {
        var entity = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

}
