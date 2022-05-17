package com.testejava.wswork.me.service;

import java.util.List;

import com.testejava.wswork.me.entity.Carro;
import com.testejava.wswork.me.entity.form.CarroForm;
import com.testejava.wswork.me.entity.form.update.CarroUpdateForm;

public interface ICarroService {
    Carro create(CarroForm form);

    Carro update(Long id, CarroUpdateForm form);

    void delete(Long id);

    List<Carro> getAll();

    Carro getById(Long id);
}
