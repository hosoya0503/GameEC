package jp.ac.morijyobi.game_management.bean.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class GameForm {
    @NotBlank
    private String title;
    private String maker;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @NotEmpty(message = "1つ以上選択してください")
    private List<@NotNull Integer> genreIDList;
    @NotEmpty(message = "1つ以上選択してください")
    private List<@NotNull Integer> consoleIDList;
    @NotEmpty(message = "1つ以上選択してください")
    private List<@NotNull Integer> modeIDList;
    @NotEmpty(message = "1つ以上選択してください")
    private List<@NotNull Integer> seriesIDList;
    private int price;
    private String dataStorage;
    @NotEmpty(message = "1つ以上選択してください")
    private List<@NotNull Integer> lantuageIDList;
    @NotEmpty(message = "1つ以上選択してください")
    private List<@NotNull Integer> ceroIDList;

    public GameForm() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Integer> getGenreIDList() {
        return genreIDList;
    }

    public void setGenreIDList(List<Integer> genreIDList) {
        this.genreIDList = genreIDList;
    }

    public List<Integer> getConsoleIDList() {
        return consoleIDList;
    }

    public void setConsoleIDList(List<Integer> consoleIDList) {
        this.consoleIDList = consoleIDList;
    }

    public List<Integer> getModeIDList() {
        return modeIDList;
    }

    public void setModeIDList(List<Integer> modeIDList) {
        this.modeIDList = modeIDList;
    }

    public List<Integer> getSeriesIDList() {
        return seriesIDList;
    }

    public void setSeriesIDList(List<Integer> seriesIDList) {
        this.seriesIDList = seriesIDList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDataStorage() {
        return dataStorage;
    }

    public void setDataStorage(String dataStorage) {
        this.dataStorage = dataStorage;
    }

    public List<Integer> getLantuageIDList() {
        return lantuageIDList;
    }

    public void setLantuageIDList(List<Integer> lantuageIDList) {
        this.lantuageIDList = lantuageIDList;
    }

    public List<Integer> getCeroIDList() {
        return ceroIDList;
    }

    public void setCeroIDList(List<Integer> ceroIDList) {
        this.ceroIDList = ceroIDList;
    }
}
