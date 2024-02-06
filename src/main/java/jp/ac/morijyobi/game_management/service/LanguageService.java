package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.Language;
import jp.ac.morijyobi.game_management.bean.form.LanguageForm;

import java.util.List;

public interface LanguageService {
    Language registerLanguage(LanguageForm languageForm);
    List<Language> getAllLanguage();
}
