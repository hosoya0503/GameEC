package jp.ac.morijyobi.game_management.mapper;

import jp.ac.morijyobi.game_management.bean.entity.Cero;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CeroMapper {
    @Insert("INSERT INTO cero VALUES (default, #{cero})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertCero(Cero cero);

    @Select("SELECT Id, cero FROM cero ORDER BY id")
    List<Cero> selectAllCero();
}
