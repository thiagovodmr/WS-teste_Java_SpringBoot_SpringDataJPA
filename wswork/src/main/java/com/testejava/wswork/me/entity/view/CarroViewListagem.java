package com.testejava.wswork.me.entity.view;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroViewListagem {
    private Long id;

    @JsonProperty("marca_id")
    private Long marcaId;

    @JsonProperty("marca_nome")
    private String marcaNome;

    @JsonProperty("nome_modelo")
    private String nomeModelo;

    private Long ano;

    private String combustivel;

    @JsonProperty("num_portas")
    private Integer numPortas;

    @JsonProperty("valor_fipe")
    private Long valorFipe;

    private String cor;

    @JsonProperty("timestamp_cadastro")
    private Timestamp timestampCadastro;

}
