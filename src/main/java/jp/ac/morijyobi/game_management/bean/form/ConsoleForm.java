package jp.ac.morijyobi.game_management.bean.form;

import jakarta.validation.constraints.NotBlank;

public class ConsoleForm {
    @NotBlank
    private String consoleName;

    public String getConsoleName() {
        return consoleName;
    }

    public void setConsoleName(String consoleName) {
        this.consoleName = consoleName;
    }
}
