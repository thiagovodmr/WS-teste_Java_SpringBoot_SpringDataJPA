package com.testejava.wswork.me.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_carros") /** padronizando o nome das tabelas */
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Timestamp timestampCadastro;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    @Column(nullable = false)
    private Long ano;

    private String combustivel;

    @Column(nullable = false)
    private Integer numPortas;

    private String cor;

}
