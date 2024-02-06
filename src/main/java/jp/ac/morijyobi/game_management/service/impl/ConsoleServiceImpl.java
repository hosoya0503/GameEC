package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.Console;
import jp.ac.morijyobi.game_management.bean.form.ConsoleForm;
import jp.ac.morijyobi.game_management.mapper.ConsolesMapper;
import jp.ac.morijyobi.game_management.service.ConsoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleServiceImpl implements ConsoleService{
    private final ConsolesMapper consolesMapper;

    public ConsoleServiceImpl(ConsolesMapper consolesMapper) {
        this.consolesMapper = consolesMapper;
    }

    @Override
    public Console registerConsole(ConsoleForm consoleForm) {
        Console console = new Console();
        console.setConsoleName(consoleForm.getConsoleName());

        consolesMapper.insertConsole(console);
        return null;
    }
    @Override
    public List<Console> getAllConsoles() {
        return consolesMapper.selectAllConsoles();
    }
}
