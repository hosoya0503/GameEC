package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.Console;
import jp.ac.morijyobi.game_management.bean.form.ConsoleForm;

import java.util.List;

public interface ConsoleService {
    Console registerConsole(ConsoleForm consoleForm);

    List<Console> getAllConsoles();
}
