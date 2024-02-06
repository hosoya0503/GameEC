package jp.ac.morijyobi.game_management.bean.form;

import jakarta.validation.constraints.NotBlank;

public class GenreForm {
    @NotBlank
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
