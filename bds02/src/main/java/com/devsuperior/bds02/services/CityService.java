package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<CityDTO> findALl() {
        List<City> cidades = repository.findAll(Sort.by("name"));
        return cidades.stream().map(city -> new CityDTO(city)).collect(Collectors.toList());
    }

    public CityDTO save(CityDTO cityDTO) {
        City cidade = new City(cityDTO.getId(), cityDTO.getName());
        var entidade = repository.save(cidade);
        return new CityDTO(entidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
