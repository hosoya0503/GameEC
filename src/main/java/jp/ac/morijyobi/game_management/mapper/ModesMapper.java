package jp.ac.morijyobi.game_management.mapper;

import jp.ac.morijyobi.game_management.bean.entity.Mode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModesMapper {
    @Insert("INSERT INTO modes VALUES (default, #{mode})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void insertMode(Mode mode);

    @Select("SELECT Id, mode FROM modes ORDER BY id")
    List<Mode> selectAllModes();
}