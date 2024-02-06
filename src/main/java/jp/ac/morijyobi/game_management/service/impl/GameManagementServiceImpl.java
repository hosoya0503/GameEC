package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.GameManagement;
import jp.ac.morijyobi.game_management.bean.form.GameManagementForm;
import jp.ac.morijyobi.game_management.mapper.GameManagementMapper;
import jp.ac.morijyobi.game_management.mapper.UsersMapper;
import jp.ac.morijyobi.game_management.service.GameManagementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameManagementServiceImpl implements GameManagementService {
    private final GameManagementMapper gameManagementMapper;
    private final UsersMapper usersMapper;

    public GameManagementServiceImpl(GameManagementMapper gameManagementMapper, UsersMapper usersMapper) {
        this.gameManagementMapper = gameManagementMapper;
        this.usersMapper = usersMapper;
    }

    @Override
    public GameManagement registerGameManagement(GameManagementForm gameManagementForm) {
        GameManagement gameManagement = new GameManagement(
                -1,
                gameManagementForm.getTitle(),
                gameManagementForm.getMaker(),
                gameManagementForm.getRelease_date(),
                gameManagementForm.getGenre(),
                gameManagementForm.getConsole(),
                gameManagementForm.getMode(),
                gameManagementForm.getSeries(),
                gameManagementForm.getPrice(),
                gameManagementForm.getData_storage(),
                gameManagementForm.getLanguage(),
                gameManagementForm.getCero()
        );
        gameManagementMapper.insertGameManagement(gameManagement);
        return gameManagement;
    }

    @Override
    public List<GameManagement> getAllGameManagements() {
        return gameManagementMapper.selectAllGameManagements();
    }

    @Override
    public List<GameManagement> getGameManagementsByKeyword(String keyword) {
        return gameManagementMapper.selectGameManagementsByKeyword(keyword);
    }

    @Override
    public GameManagement getGameManagementById(int id) {
        return gameManagementMapper.selectGameManagementById(id);

    }
    @Override
    public int deleteGameManagementById(int id) {
        return gameManagementMapper.deleteGameManagementById(id);
    }

    @Override
    public int updateGameManagement(GameManagement gameManagement) {
        return gameManagementMapper.updateGameManagement(gameManagement);
    }


}
