package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.Mode;
import jp.ac.morijyobi.game_management.bean.form.ModeForm;

import java.util.List;

public interface ModeService {
    Mode registerMode(ModeForm modeForm);
    List<Mode> getAllModes();
}
