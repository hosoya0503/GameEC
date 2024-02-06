package jp.ac.morijyobi.game_management.bean.form;

import java.time.LocalDate;

public class GameManagementForm {
    private String title;       //タイトル
    private String maker;       //メーカー
    private LocalDate release_date;     //発売日
    private String genre;       //ジャンル
    private String console;     //対応機種
    private String mode;        //モード（人数）
    private String series;      //シリーズ
    private String price;       //金額
    private String data_storage;        //データ容量
    private String language;        //対応言語
    private String cero;        //cero

    public GameManagementForm(String title, String maker, LocalDate releaseDate, String genre, String console, String mode, String series, String price, String dataStorage, String language, String cero) {
        this.title = title;
        this.maker = maker;
        release_date = releaseDate;
        this.genre = genre;
        this.console = console;
        this.mode = mode;
        this.series = series;
        this.price = price;
        data_storage = dataStorage;
        this.language = language;
        this.cero = cero;
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

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getData_storage() {
        return data_storage;
    }

    public void setData_storage(String data_storage) {
        this.data_storage = data_storage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCero() {
        return cero;
    }

    public void setCero(String cero) {
        this.cero = cero;
    }
}
