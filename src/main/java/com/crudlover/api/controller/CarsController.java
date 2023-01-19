package com.crudlover.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.dto.CarsDTO;
import com.crudlover.api.model.Cars;
import com.crudlover.api.repository.CarsRepository;

@RestController
@RequestMapping("/")
public class CarsController {
    @Autowired
    private CarsRepository repository;

    @GetMapping
    public List<Cars> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody CarsDTO req) {
        repository.save(new Cars(req));
    }

    @PostMapping("/show")
    public CarsDTO showData(@RequestBody CarsDTO req) {
        System.out.println(req.modelo());
        System.out.println(req.fabricante());
        System.out.println(req.dataFabricacao());
        System.out.println(req.valor());
        System.out.println(req.anoModelo());
        return req;
    }
}
