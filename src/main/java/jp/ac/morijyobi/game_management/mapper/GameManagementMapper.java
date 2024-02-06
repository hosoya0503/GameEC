package jp.ac.morijyobi.game_management.mapper;

import jp.ac.morijyobi.game_management.bean.entity.GameManagement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameManagementMapper {
    @Insert("INSERT INTO game_management(title, maker, release_date, genre, console, mode, series, price, data_storage, language, cero)" +
            "VALUES(#{title}, #{maker}, #{release_date}, #{genre}, #{console},#{mode}, #{series}, #{price}, #{data_storage}, #{language}, #{cero})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertGameManagement(GameManagement gameManagement);
    @Select("SELECT * FROM game_management WHERE title LIKE CONCAT('%', #{keyword}, '%') ORDER BY id")
    List<GameManagement> selectGameManagementsByKeyword(String keyword);

    @Select("SELECT * FROM game_management")
    List<GameManagement> selectAllGameManagements();

    @Select("Select * FROM game_management WHERE id =#{id}")
    GameManagement selectGameManagementById(int id);

    @Delete("DELETE FROM game_management WHERE id = #{id}")
    int deleteGameManagementById(int id);

    @Update("UPDATE game_management SET title = #{title}," +
            "maker = #{maker}," +
            "release_date = #{release_date}," +
            "genre = #{genre}," +
            "console = #{console}," +
            "mode = #{mode}," +
            "series = #{series}," +
            "price =  #{price}," +
            "data_storage =  #{data_storage}," +
            "language = #{language}," +
            "cero = #{cero} " +
            "WHERE id = #{id}")
    int updateGameManagement(GameManagement gameManagement);
}
