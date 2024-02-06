package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.GameManagement;
import jp.ac.morijyobi.game_management.bean.form.GameManagementForm;

import java.util.List;

public interface GameManagementService {
    //void  registerGameManagement(GameManagementForm gameManagementForm);
    GameManagement registerGameManagement(GameManagementForm gameManagementForm);
    List<GameManagement> getAllGameManagements();
    List<GameManagement> getGameManagementsByKeyword(String keyword);
    GameManagement getGameManagementById(int id);

    int deleteGameManagementById(int id);

    int updateGameManagement(GameManagement gameManagement);

}
