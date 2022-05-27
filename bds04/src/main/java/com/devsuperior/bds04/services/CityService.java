package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CityDTO> findAll(Pageable pageable) {
        var result = repository.findAll(Sort.by("name").ascending());
        List<CityDTO> response = new ArrayList<>();
        result.forEach(city -> response.add(new CityDTO(city)));
        return response;
    }

    @Transactional
    public CityDTO save(CityDTO dto) {
        var entity = repository.save(new City(dto));
        return new CityDTO(entity);
    }



}
