package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.entity.Cero;
import jp.ac.morijyobi.game_management.bean.form.CeroForm;
import jp.ac.morijyobi.game_management.service.CeroService;
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
@RequestMapping("/cero")
public class CeroController {
    private final CeroService ceroService;

    public CeroController(CeroService ceroService) {
        this.ceroService = ceroService;
    }

    @GetMapping("/register")
    public String register(Model model){
        CeroForm ceroForm = new CeroForm();
        model.addAttribute("ceroForm",ceroForm);

        List<Cero> ceroList = ceroService.getAllCero();
        model.addAttribute("ceroList",ceroList);
        return "cero/register-cero";
    }

    @PostMapping("/register")
    public String registerExe(@Validated CeroForm ceroForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "cero/register-cero";
        }

        ceroService.registerCero(ceroForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました");

        return "redirect:/cero/register";
    }
}
