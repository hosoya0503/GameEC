package jp.ac.morijyobi.game_management.mapper;

import jp.ac.morijyobi.game_management.bean.entity.Genre;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GenresMapper {
    @Insert("INSERT INTO genres VALUES (default, #{genreName})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void insertGenre(Genre genre);

    @Select("SELECT Id, genre_name FROM genres ORDER BY id")
    List<Genre> selectAllGenres();
}
