package com.testejava.wswork.me.entity.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 1950, message = "O Ano tem que ser superior ou igual a 1950")
    private Long ano;

    @NotEmpty(message = "Você precisa informar o tipo de combustível")
    private String combustivel;

    @NotNull(message = "Você precisa informar o campo número de portas")
    @Max(value = 7, message = "numero de portas pode ser no máximo igual a 7")
    @Min(value = 2, message = "numero de portas tem que ser no mínimo igual 2")
    private Integer numPortas;

    @NotEmpty(message = "você precisa informar a cor do carro")
    private String cor;
}
