package jp.ac.morijyobi.game_management.mapper;

import jp.ac.morijyobi.game_management.bean.entity.Language;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LanguageMapper {
    @Insert("INSERT INTO language VALUES (default, #{language})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    void insertLanguage(Language language);

    @Select("SELECT Id, language FROM language ORDER BY id")
    List<Language> selectAllLanguage();
}
