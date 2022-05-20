package com.testejava.wswork.me.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.testejava.wswork.me.configurations.Exceptions.IdNotFoundException;
import com.testejava.wswork.me.entity.Marca;
import com.testejava.wswork.me.entity.Modelo;
import com.testejava.wswork.me.entity.form.ModeloForm;
import com.testejava.wswork.me.entity.form.update.ModeloUpdateForm;
import com.testejava.wswork.me.repository.MarcaRepository;
import com.testejava.wswork.me.repository.ModeloRepository;
import com.testejava.wswork.me.service.IModeloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ModeloServiceImpl implements IModeloService {
    @Autowired
    private ModeloRepository repository;
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Modelo create(ModeloForm form) {
        try {
            Modelo modelo = new Modelo();
            Marca marca = marcaRepository.findById(form.getMarcaId()).get();

            modelo.setNome(form.getNome());
            modelo.setValorFipe(form.getValorFipe());
            modelo.setMarca(marca);

            return repository.save(modelo);
        } catch (NoSuchElementException e) {
            throw new IdNotFoundException("Marca não encontrada no sistema");
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Modelo update(Long id, ModeloUpdateForm form) {
        try {
            Modelo modelo = repository.findById(id).get();
            modelo.setValorFipe(form.getValorFipe());

            return repository.save(modelo);
        } catch (NoSuchElementException e) {
            throw new IdNotFoundException("Modelo não encontrado, Verifique o Id");
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IdNotFoundException("Não foi possível deletar, Id não foi encontrado");
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<Modelo> getAll() {
        return repository.findAll();
    }

    @Override
    public Modelo getById(long id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new IdNotFoundException("modelo não encontrado no sistema");
        } catch (Exception e) {
            throw e;
        }
    }

}
