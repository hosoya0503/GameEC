package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.Cero;
import jp.ac.morijyobi.game_management.bean.form.CeroForm;
import jp.ac.morijyobi.game_management.mapper.CeroMapper;
import jp.ac.morijyobi.game_management.service.CeroService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CeroServiceImpl implements CeroService {
    private final CeroMapper ceroMapper;

    public CeroServiceImpl(CeroMapper ceroMapper) {
        this.ceroMapper = ceroMapper;
    }
    @Override
    public Cero registerCero(CeroForm ceroForm) {
        Cero cero = new Cero();
        cero.setCero(ceroForm.getCero());

        ceroMapper.insertCero(cero);
        return null;
    }

    @Override
    public List<Cero> getAllCero() {
        return ceroMapper.selectAllCero();
    }
}
