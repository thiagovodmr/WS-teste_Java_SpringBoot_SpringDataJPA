package com.testejava.wswork.me.service;

import java.util.List;

import com.testejava.wswork.me.entity.Marca;
import com.testejava.wswork.me.entity.form.MarcaForm;
import com.testejava.wswork.me.entity.form.update.MarcaUpdateForm;

public interface IMarcaService {
    Marca create(MarcaForm form);

    Marca update(Long id, MarcaUpdateForm form);

    void delete(Long id);

    List<Marca> getAll();

    Marca getById(Long id);
}
