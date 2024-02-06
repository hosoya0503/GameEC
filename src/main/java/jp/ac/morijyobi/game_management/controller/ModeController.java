package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.entity.Mode;
import jp.ac.morijyobi.game_management.bean.form.ModeForm;
import jp.ac.morijyobi.game_management.service.ModeService;
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
@RequestMapping("/mode")
public class ModeController {
    private final ModeService modeService;

    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

    @GetMapping("/register")
    public String register(Model model){
        ModeForm modeForm = new ModeForm();
        model.addAttribute("modeForm",modeForm);

        List<Mode> modeList = modeService.getAllModes();
        model.addAttribute("modeList",modeList);
        return "mode/register-mode";
    }

    @PostMapping("/register")
    public String registerExe(@Validated ModeForm modeForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "mode/register-mode";
        }

        modeService.registerMode(modeForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました");

        return "redirect:/mode/register";
    }
}
