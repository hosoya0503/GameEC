package jp.ac.morijyobi.game_management.bean.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CeroForm {
    @NotBlank
    @Size(min=1,max=1)
    private String cero;

    public String getCero() {
        return cero;
    }

    public void setCero(String cero) {
        this.cero = cero;
    }
}
