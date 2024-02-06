package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.Cero;
import jp.ac.morijyobi.game_management.bean.form.CeroForm;

import java.util.List;

public interface CeroService {
    Cero registerCero(CeroForm ceroForm);
    List<Cero> getAllCero();
}
