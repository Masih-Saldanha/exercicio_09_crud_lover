package com.crudlover.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlover.api.dto.CarsDTO;
import com.crudlover.api.model.Cars;
import com.crudlover.api.repository.CarsRepository;

@Service
public class CarsService {
    @Autowired
    private CarsRepository repository;

    public List<Cars> listAll() {
        return repository.findAll();
    }

    public Cars create(CarsDTO dto) {
        return repository.save(new Cars(dto));
    }

    public Optional<Cars> update(Long id, CarsDTO dto) {
        return repository.findById(id).map(car -> {
            car.setModelo(dto.modelo());
            car.setFabricante(dto.fabricante());
            car.setDataFabricacao(dto.dataFabricacao());
            car.setValor(dto.valor());
            car.setAnoModelo(dto.anoModelo());
            return repository.save(car);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CarsDTO showData(CarsDTO dto) {
        System.out.println(dto.modelo());
        System.out.println(dto.fabricante());
        System.out.println(dto.dataFabricacao());
        System.out.println(dto.valor());
        System.out.println(dto.anoModelo());
        return dto;
    }
}
