package com.crudlover.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.dto.CarsDTO;
import com.crudlover.api.model.Cars;
import com.crudlover.api.service.CarsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class CarsController {
    @Autowired
    private CarsService service;

    @GetMapping
    public List<Cars> listAll() {
        return service.listAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid CarsDTO req) {
        service.create(req);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarsDTO req) {
        service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/show")
    public CarsDTO showData(@RequestBody @Valid CarsDTO req) {
        return service.showData(req);
    }
}
