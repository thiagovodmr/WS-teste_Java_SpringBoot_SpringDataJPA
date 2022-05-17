package com.testejava.wswork.me.entity.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroForm {
    @NotNull(message = "você precisa informar o id do modelo")
    @Positive(message = "o Id do modelo precisa ser um valor positivo")
    private Long modeloId;

    @Positive(message = "o campo ano precisa ter um valor positivo")
    private Long ano;

    @NotEmpty(message = "Você precisa informar o tipo de combustível")
    private String combustivel;

    @NotNull(message = "Você precisa informar o campo número de portas")
    private Integer numPortas;

    private String cor;
}
