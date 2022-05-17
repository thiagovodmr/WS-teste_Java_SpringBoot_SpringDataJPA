package com.testejava.wswork.me.entity.form.update;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroUpdateForm {
    @NotEmpty(message = "o campo combustivel precisa ser preenchido")
    private String combustivel;
    @NotEmpty(message = "o campo cor precisa ser preenchido")
    private String cor;
}
