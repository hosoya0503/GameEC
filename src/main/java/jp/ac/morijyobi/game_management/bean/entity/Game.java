package jp.ac.morijyobi.game_management.bean.entity;

import java.time.LocalDate;
import java.util.Date;

public class Game {
    private int Id;
    private String title;
    private String maker;
    private LocalDate releaseDate;
    private int price;
    private String dataStorage;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
}
