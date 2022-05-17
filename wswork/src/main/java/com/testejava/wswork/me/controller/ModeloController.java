package com.testejava.wswork.me.controller;

import java.util.List;

import javax.validation.Valid;

import com.testejava.wswork.me.entity.Modelo;
import com.testejava.wswork.me.entity.form.ModeloForm;
import com.testejava.wswork.me.entity.form.update.ModeloUpdateForm;
import com.testejava.wswork.me.service.impl.ModeloServiceImpl;

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
@RequestMapping("/modelos")
public class ModeloController {
    @Autowired
    private ModeloServiceImpl service;

    @GetMapping
    public List<Modelo> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Modelo getMarcaById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Modelo create(@Valid @RequestBody ModeloForm form) {
        return service.create(form);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("{id}")
    public Modelo update(@PathVariable Long id, @Valid @RequestBody ModeloUpdateForm form) {
        return service.update(id, form);
    }

}
