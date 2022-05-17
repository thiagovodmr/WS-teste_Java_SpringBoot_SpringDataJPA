package com.testejava.wswork.me.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.testejava.wswork.me.entity.Carro;
import com.testejava.wswork.me.entity.Marca;
import com.testejava.wswork.me.entity.Modelo;
import com.testejava.wswork.me.entity.form.CarroForm;
import com.testejava.wswork.me.entity.form.update.CarroUpdateForm;
import com.testejava.wswork.me.entity.view.CarroViewListagem;
import com.testejava.wswork.me.repository.CarroRepository;
import com.testejava.wswork.me.repository.ModeloRepository;
import com.testejava.wswork.me.service.ICarroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroServiceImpl implements ICarroService {
    @Autowired
    private CarroRepository repository;
    @Autowired
    ModeloRepository modeloRepository;

    @Override
    public Carro create(CarroForm form) {
        Carro carro = new Carro();
        Modelo modelo = modeloRepository.findById(form.getModeloId()).get();

        carro.setAno(form.getAno());
        carro.setCombustivel(form.getCombustivel());
        carro.setCor(form.getCor());
        carro.setNumPortas(form.getNumPortas());
        carro.setModelo(modelo);

        return repository.save(carro);

    }

    @Override
    public Carro update(Long id, CarroUpdateForm form) {
        Carro carro = repository.findById(id).get();
        carro.setCombustivel(form.getCombustivel());
        carro.setCor(form.getCor());

        return repository.save(carro);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Carro> getAll() {
        return repository.findAll();
    }

    @Override
    public Carro getById(Long id) {
        return repository.findById(id).get();
    }

    public List<CarroViewListagem> getAllCarrosWithModeloMarca() {
        List<CarroViewListagem> viewCarros = new ArrayList<CarroViewListagem>();

        List<Carro> carros = repository.findAll();
        for (Carro carro : carros) {
            Modelo modelo = carro.getModelo();
            Marca marca = modelo.getMarca();

            CarroViewListagem lista = new CarroViewListagem();
            lista.setId(carro.getId());
            lista.setCor(carro.getCor());
            lista.setTimestampCadastro(carro.getTimestampCadastro());
            lista.setValorFipe(modelo.getValorFipe());
            lista.setNumPortas(carro.getNumPortas());
            lista.setCombustivel(carro.getCombustivel());
            lista.setAno(carro.getAno());
            lista.setNomeModelo(modelo.getNome());
            lista.setMarcaNome(marca.getNomeMarca());
            lista.setMarcaId(marca.getId());

            viewCarros.add(lista);
        }
        return viewCarros;
    }

}
