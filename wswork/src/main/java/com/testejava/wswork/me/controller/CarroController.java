package com.testejava.wswork.me.controller;

import java.util.List;

import javax.validation.Valid;

import com.testejava.wswork.me.entity.Carro;
import com.testejava.wswork.me.entity.form.CarroForm;
import com.testejava.wswork.me.entity.form.update.CarroUpdateForm;
import com.testejava.wswork.me.service.impl.CarroServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroServiceImpl service;

    @GetMapping
    public List<Carro> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Carro getCarroById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Carro create(@Valid @RequestBody CarroForm form) {
        return service.create(form);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("{id}")
    public Carro update(@PathVariable Long id, @Valid @RequestBody CarroUpdateForm form) {
        return service.update(id, form);
    }

}
