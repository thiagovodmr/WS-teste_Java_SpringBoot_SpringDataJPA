package com.testejava.wswork.me.controller;

import java.util.List;

import javax.validation.Valid;

import com.testejava.wswork.me.entity.Marca;
import com.testejava.wswork.me.entity.form.MarcaForm;
import com.testejava.wswork.me.entity.form.update.MarcaUpdateForm;
import com.testejava.wswork.me.service.impl.MarcaServiceImpl;

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
@RequestMapping("/marcas")
public class MarcaController {
    @Autowired
    private MarcaServiceImpl service;

    @GetMapping
    public List<Marca> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Marca getMarcaById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Marca create(@Valid @RequestBody MarcaForm form) {
        return service.create(form);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("{id}")
    public Marca update(@PathVariable Long id, @Valid @RequestBody MarcaUpdateForm form) {
        return service.update(id, form);
    }

}
