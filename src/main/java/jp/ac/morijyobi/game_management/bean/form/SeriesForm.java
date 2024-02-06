package jp.ac.morijyobi.game_management.bean.form;

import jakarta.validation.constraints.NotBlank;

public class SeriesForm {
    @NotBlank
    private String seriesName;

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
}
