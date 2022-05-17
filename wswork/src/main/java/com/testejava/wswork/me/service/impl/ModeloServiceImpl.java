package com.testejava.wswork.me.service.impl;

import java.util.List;

import com.testejava.wswork.me.entity.Marca;
import com.testejava.wswork.me.entity.Modelo;
import com.testejava.wswork.me.entity.form.ModeloForm;
import com.testejava.wswork.me.entity.form.update.ModeloUpdateForm;
import com.testejava.wswork.me.repository.MarcaRepository;
import com.testejava.wswork.me.repository.ModeloRepository;
import com.testejava.wswork.me.service.IModeloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloServiceImpl implements IModeloService {
    @Autowired
    private ModeloRepository repository;
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Modelo create(ModeloForm form) {
        Modelo modelo = new Modelo();
        Marca marca = marcaRepository.findById(form.getMarcaId()).get();

        modelo.setNome(form.getNome());
        modelo.setValorFipe(form.getValorFipe());
        modelo.setMarca(marca);

        return repository.save(modelo);
    }

    @Override
    public Modelo update(Long id, ModeloUpdateForm form) {
        Modelo modelo = repository.findById(id).get();
        modelo.setValorFipe(form.getValorFipe());

        return repository.save(modelo);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public List<Modelo> getAll() {
        return repository.findAll();
    }

    @Override
    public Modelo getById(long id) {
        return repository.findById(id).get();
    }

}
