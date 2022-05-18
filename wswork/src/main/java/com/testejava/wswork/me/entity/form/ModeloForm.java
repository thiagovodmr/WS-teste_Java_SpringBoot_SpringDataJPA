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
public class ModeloForm {
    @NotNull(message = "você precisa informar o id da marca")
    @Positive(message = "o Id da Marca precisa ser um valor positivo")
    private Long marcaId;

    @NotEmpty(message = "você presica informar o nome da marca")
    private String nome;

    @NotNull(message = "você precisa informar o valor FIPE")
    @Positive(message = "o Valor FIPE precisa ser um valor positivo")
    private Long valorFipe;
}
