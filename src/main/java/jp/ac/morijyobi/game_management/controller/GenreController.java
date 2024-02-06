package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.entity.Genre;
import jp.ac.morijyobi.game_management.bean.form.GenreForm;
import jp.ac.morijyobi.game_management.service.GenreService;
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
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/register")
    public String register(Model model){
        GenreForm genreForm = new GenreForm();
        model.addAttribute("genreForm",genreForm);

        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("genreList",genreList);
        return "genre/register-genre";
    }

    @PostMapping("/register")
    public String registerExe(@Validated GenreForm genreForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "genre/register-genre";
        }

        genreService.registerGenre(genreForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました");

        return "redirect:/genre/register";
    }
}
