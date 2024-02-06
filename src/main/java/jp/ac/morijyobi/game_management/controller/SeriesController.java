package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.entity.Series;
import jp.ac.morijyobi.game_management.bean.form.SeriesForm;
import jp.ac.morijyobi.game_management.service.SeriesService;
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
@RequestMapping("/series")
public class SeriesController {
    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/register")
    public String register(Model model){
        SeriesForm seriesForm = new SeriesForm();
        model.addAttribute("seriesForm",seriesForm);

        List<Series> seriesList = seriesService.getAllSeries();
        model.addAttribute("seriesList",seriesList);
        return "series/register-series";
    }

    @PostMapping("/register")
    public String registerExe(@Validated SeriesForm seriesForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "series/register-series";
        }

        seriesService.registerSeries(seriesForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました");

        return "redirect:/genre/register";
    }
}
