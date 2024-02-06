package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.entity.Console;
import jp.ac.morijyobi.game_management.bean.form.ConsoleForm;
import jp.ac.morijyobi.game_management.service.ConsoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/console")
public class ConsoleController {
    private final ConsoleService consoleService;


    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }
    @GetMapping("/register")
    public String register(Model model){
        ConsoleForm consoleForm = new ConsoleForm();
        model.addAttribute("consoleForm",consoleForm);

        List<Console> consoleList = consoleService.getAllConsoles();
            model.addAttribute("consoleList",consoleList);
        return "console/register-console";
    }
    @PostMapping("/register")
    public String registerExe(@Validated ConsoleForm consoleForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model){
        if(bindingResult.hasErrors()){
            return "console/register-console";
        }

        consoleService.registerConsole(consoleForm);
        redirectAttributes.addFlashAttribute("message","登録が完了しました");

        return "redirect:/console/register";
    }

}
