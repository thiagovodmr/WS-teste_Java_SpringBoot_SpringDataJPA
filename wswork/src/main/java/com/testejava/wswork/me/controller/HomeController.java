package com.testejava.wswork.me.controller;

import java.util.List;

import com.testejava.wswork.me.entity.view.CarroViewListagem;
import com.testejava.wswork.me.service.impl.CarroServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CarroServiceImpl carroService;

    @GetMapping
    public List<CarroViewListagem> listCarrosWithInfo() {
        return carroService.getAllCarrosWithModeloMarca();
    }
}
