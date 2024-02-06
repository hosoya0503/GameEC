package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.Language;
import jp.ac.morijyobi.game_management.bean.form.LanguageForm;
import jp.ac.morijyobi.game_management.mapper.LanguageMapper;
import jp.ac.morijyobi.game_management.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageMapper languageMapper;

    public LanguageServiceImpl(LanguageMapper languageMapper) {
        this.languageMapper = languageMapper;
    }
    @Override
    public Language registerLanguage(LanguageForm languageForm) {
        Language language = new Language();
        language.setLanguage(languageForm.getLanguage());

        languageMapper.insertLanguage(language);
        return null;
    }

    @Override
    public List<Language> getAllLanguage() {
        return languageMapper.selectAllLanguage();
    }
}
