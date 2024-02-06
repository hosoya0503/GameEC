package jp.ac.morijyobi.game_management.mapper;

import jp.ac.morijyobi.game_management.bean.entity.Console;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConsolesMapper {
    @Insert("INSERT INTO consoles VALUES(default, #{consoleName})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void insertConsole(Console console);

    @Select("SELECT  Id, console_name FROM consoles ORDER BY id")
    List<Console> selectAllConsoles();
}
