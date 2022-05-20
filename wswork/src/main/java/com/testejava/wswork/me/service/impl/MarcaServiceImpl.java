package com.testejava.wswork.me.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.testejava.wswork.me.configurations.Exceptions.IdNotFoundException;
import com.testejava.wswork.me.entity.Marca;
import com.testejava.wswork.me.entity.form.MarcaForm;
import com.testejava.wswork.me.entity.form.update.MarcaUpdateForm;
import com.testejava.wswork.me.repository.MarcaRepository;
import com.testejava.wswork.me.service.IMarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            Marca marca = repository.findById(id).get();
            marca.setNomeMarca(form.getNomeMarca());

            return repository.save(marca);
        } catch (NoSuchElementException e) {
            throw new IdNotFoundException("objeto marca não encontrado, verifique o Id");
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IdNotFoundException("Não foi possível deletar o registro, registro não encontrado");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Marca> getAll() {
        return repository.findAll();
    }

    @Override
    public Marca getById(Long id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new IdNotFoundException("objeto marca não encontrado, verifique o Id passado como parâmetro");
        } catch (Exception e) {
            throw e;
        }

    }

}
