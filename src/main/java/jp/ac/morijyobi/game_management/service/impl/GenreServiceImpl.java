package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.Genre;
import jp.ac.morijyobi.game_management.bean.form.GenreForm;
import jp.ac.morijyobi.game_management.mapper.GenresMapper;
import jp.ac.morijyobi.game_management.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreServiceImpl implements GenreService {
    private final GenresMapper genresMapper;

    public GenreServiceImpl(GenresMapper genresMapper) {
        this.genresMapper = genresMapper;
    }
    @Override
    public Genre registerGenre(GenreForm genreForm) {
        Genre genre = new Genre();
        genre.setGenreName(genreForm.getGenreName());

        genresMapper.insertGenre(genre);
        return null;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genresMapper.selectAllGenres();
    }
}
