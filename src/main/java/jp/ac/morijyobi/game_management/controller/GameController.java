package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.dto.LoanedBookDTO;
import jp.ac.morijyobi.game_management.bean.entity.Game;
import jp.ac.morijyobi.game_management.bean.entity.Cero;
import jp.ac.morijyobi.game_management.bean.entity.Console;
import jp.ac.morijyobi.game_management.bean.entity.Genre;
import jp.ac.morijyobi.game_management.bean.entity.Language;
import jp.ac.morijyobi.game_management.bean.entity.Mode;
import jp.ac.morijyobi.game_management.bean.entity.Series;

import jp.ac.morijyobi.game_management.bean.form.GameForm;
import jp.ac.morijyobi.game_management.service.GameService;
import jp.ac.morijyobi.game_management.service.GenreService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GenreService genreService;
    private final GameService gameService;

    public GameController(GenreService genreService, GameService gameService) {
        this.genreService = genreService;
        this.gameService = gameService;
    }

    @GetMapping("/register")
    public String registerGame(Model model) {

        GameForm gameForm = new GameForm();
        model.addAttribute("gameForm", gameForm);

        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("genreList", genreList);

        return "game/register-game";
    }

    @PostMapping("/register")
    public String registerExe(@Validated GameForm gameForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bindingResult.hasErrors()) {
            List<Genre> genreList = genreService.getAllGenres();
            model.addAttribute("genreList", genreList);

            return "game/register-game";
        }

        gameService.registerGame(gameForm);
        redirectAttributes.addFlashAttribute("message", "登録が完了しました。");

        return "redirect:/game/register";
    }

    @GetMapping("/list")
    public String gameList(@RequestParam(defaultValue = "") String keyword,
                           Model model) {

        List<Game> gameList = gameService.getGamesByKeyword(keyword);
        model.addAttribute("gameList", gameList);
        return "game/game-list";
    }

    @GetMapping("/purchase")
    public String gamepurchase(@RequestParam int gameId,
                           Model model) {
        Game game = gameService.getGameById(gameId);
        model.addAttribute("game", game);
        return "game/game-purchase";
    }

    @PostMapping("/loan")
    public String bookLoanExe(@RequestParam int id,
                              @AuthenticationPrincipal UserDetails userDetails,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        if (bookService.registerBookLoan(id, userDetails.getUsername())) {
            redirectAttributes.addFlashAttribute("message", "貸出が完了しました");
        } else {
            redirectAttributes.addFlashAttribute("warning", "貸出が失敗しました");
        }
        return "redirect:/book/list";
    }

    @GetMapping("/loans")
    public String loanedBooks(@AuthenticationPrincipal UserDetails userDetails,Model model){
        List<LoanedBookDTO> loanedBookList = bookService.getLoanedBooksByUser(userDetails);
        model.addAttribute("LoanedBookList",loanedBookList);
        return "book/loaned-books";
    }

    @GetMapping("return")
    public String returnBook(@RequestParam int bookId,
                             @AuthenticationPrincipal UserDetails userDetails,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (bookService.returnBookLoans(bookId, userDetails)) {
            redirectAttributes.addFlashAttribute("message", "返却が完了しました。");
        } else {
            redirectAttributes.addFlashAttribute("warning", "返却に失敗しました。");
        }
        return "redirect:/book/loans";
    }
}