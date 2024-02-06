package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.Genre;
import jp.ac.morijyobi.game_management.bean.form.GenreForm;

import java.util.List;

public interface GenreService {
    Genre registerGenre(GenreForm genreForm);
    List<Genre> getAllGenres();
}
