package jp.ac.morijyobi.game_management.bean.form;

import jakarta.validation.constraints.NotBlank;

public class LanguageForm {
    @NotBlank
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
