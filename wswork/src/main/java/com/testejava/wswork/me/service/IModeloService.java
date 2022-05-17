package com.testejava.wswork.me.service;

import java.util.List;

import com.testejava.wswork.me.entity.Modelo;
import com.testejava.wswork.me.entity.form.ModeloForm;
import com.testejava.wswork.me.entity.form.update.ModeloUpdateForm;

public interface IModeloService {
    Modelo create(ModeloForm form);

    Modelo update(Long id, ModeloUpdateForm form);

    void delete(Long id);

    List<Modelo> getAll();

    Modelo getById(long id);
}