package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.Mode;
import jp.ac.morijyobi.game_management.bean.form.ModeForm;
import jp.ac.morijyobi.game_management.mapper.ModesMapper;
import jp.ac.morijyobi.game_management.service.ModeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeServiceImpl implements ModeService {
    private final ModesMapper modesMapper;

    public ModeServiceImpl(ModesMapper modesMapper) {
        this.modesMapper = modesMapper;
    }
    @Override
    public Mode registerMode(ModeForm modeForm) {
        Mode mode = new Mode();
        mode.setMode(modeForm.getMode());

        modesMapper.insertMode(mode);
        return null;
    }

    @Override
    public List<Mode> getAllModes() {
        return modesMapper.selectAllModes();
    }
}
