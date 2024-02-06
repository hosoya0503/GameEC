package jp.ac.morijyobi.game_management.bean.form;

import jakarta.validation.constraints.NotBlank;

public class ModeForm {
    @NotBlank
    private String mode;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
