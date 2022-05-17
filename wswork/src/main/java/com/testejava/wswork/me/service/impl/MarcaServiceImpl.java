package com.testejava.wswork.me.service.impl;

import java.util.List;

import com.testejava.wswork.me.entity.Marca;
import com.testejava.wswork.me.entity.form.MarcaForm;
import com.testejava.wswork.me.entity.form.update.MarcaUpdateForm;
import com.testejava.wswork.me.repository.MarcaRepository;
import com.testejava.wswork.me.service.IMarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements IMarcaService {
    @Autowired
    private MarcaRepository repository;

    @Override
    public Marca create(MarcaForm form) {
        Marca marca = new Marca();
        marca.setNomeMarca(form.getNomeMarca());

        return repository.save(marca);
    }

    @Override
    public Marca update(Long id, MarcaUpdateForm form) {
        Marca marca = repository.findById(id).get();
        marca.setNomeMarca(form.getNomeMarca());

        return repository.save(marca);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Marca> getAll() {
        return repository.findAll();
    }

    @Override
    public Marca getById(Long id) {
        return repository.findById(id).get();
    }

}
