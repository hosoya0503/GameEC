package jp.ac.morijyobi.game_management.mapper;

import jp.ac.morijyobi.game_management.bean.entity.Series;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SeriesMapper {
    @Insert("INSERT INTO series VALUES (default, #{SeriesName})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void insertSeries(Series series);

    @Select("SELECT Id, series_name FROM series ORDER BY id")
    List<Series> selectAllSeries();
}
