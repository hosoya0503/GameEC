package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.entity.Language;
import jp.ac.morijyobi.game_management.bean.form.LanguageForm;
import jp.ac.morijyobi.game_management.service.LanguageService;
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
@RequestMapping("/language")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/register")
    public String register(Model model){
        LanguageForm languageForm = new LanguageForm();
        model.addAttribute("languageForm",languageForm);

        List<Language> languageList = languageService.getAllLanguage();
        model.addAttribute("languageList",languageList);
        return "language/register-language";
    }

    @PostMapping("/register")
    public String registerExe(@Validated LanguageForm languageForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "language/register-language";
        }

        languageService.registerLanguage(languageForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました");

        return "redirect:/language/register";
    }
}

