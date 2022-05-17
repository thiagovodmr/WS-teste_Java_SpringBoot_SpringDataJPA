package com.testejava.wswork.me.entity.form.update;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloUpdateForm {
    @Positive(message = "o campo Valor FIPE precisa ter um valor positivo")
    private Long valorFipe;
}
