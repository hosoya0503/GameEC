package jp.ac.morijyobi.game_management.controller;

import jp.ac.morijyobi.game_management.bean.entity.GameManagement;
import jp.ac.morijyobi.game_management.bean.form.GameManagementForm;
import jp.ac.morijyobi.game_management.service.GameManagementService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/gameManagement")
public class GameManagementController {
    private final GameManagementService gameManagementService;

    public GameManagementController(GameManagementService gameManagementService){
        this.gameManagementService = gameManagementService;

    }

    @GetMapping("/home")
    public String home() {
        return "gameManagement/home";
    }

    @GetMapping("/register")
    public String register(){
        return "gameManagement/register";
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<GameManagement> gameManagementList = gameManagementService.getAllGameManagements();
        model.addAttribute("gameManagementList",gameManagementList);
        return "gameManagement/list";
    }

    @PostMapping("/list")
    public String list(@RequestParam String title,
                       @RequestParam String maker,
                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate release_date,
                       @RequestParam String genre,
                       @RequestParam String console,
                       @RequestParam String mode,
                       @RequestParam String series,
                       @RequestParam String price,
                       @RequestParam String data_storage,
                       @RequestParam String language,
                       @RequestParam String cero,
                       Model model) {

        GameManagementForm form = new GameManagementForm(title, maker, release_date,
                genre, console, mode, series, price, data_storage, language, cero);
        GameManagement gameManagement = gameManagementService.registerGameManagement(form); //INSERT文を実行する

        List<GameManagement> gameManagementList = gameManagementService.getAllGameManagements(); //SELECT文を実行する
        model.addAttribute("gameManagementList",gameManagementList);

        return "redirect:/gameManagement/list";
    }


    @GetMapping("/display-details")
    public String displayDetails(@RequestParam int gameManagementId,
                                 Model model){
        GameManagement gameManagement = gameManagementService.getGameManagementById(gameManagementId);
        model.addAttribute("gameManagement", gameManagement);
        return "gameManagement/details";
    }

    @GetMapping("/confirm-delete")
    public String confirmDelete(@RequestParam int gameManagementId,
                                Model model){
        GameManagement gameManagement = gameManagementService.getGameManagementById(gameManagementId);
        model.addAttribute("gameManagement",gameManagement);
        return "gameManagement/confirm-delete";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int Id,Model model) {
        int result = gameManagementService.deleteGameManagementById(Id);

        if (result == 1) {
            return "gameManagement/delete-success";
        } else {
            return "gameManagement/delete-failure";
        }
    }

    @GetMapping("/confirm-edit")
    public String confirmEdit(@RequestParam int gameManagementId
            ,Model model){
        GameManagement gameManagement = gameManagementService.getGameManagementById(gameManagementId);
        model.addAttribute("gameManagement", gameManagement);
        return "gameManagement/edit";
    }

    @PostMapping("/edit")
    public String  edit(GameManagement gameManagement, Model model) {
        int result = gameManagementService.updateGameManagement(gameManagement);

        if(result == 1){
            model.addAttribute("title","変更完了");
            model.addAttribute("message" ,"変更が完了しました。");
        }else{
            model.addAttribute("title","変更失敗");
            model.addAttribute("message" ,"変更に失敗しました。");
        }
        return "gameManagement/edit-result";
    }

    @GetMapping("/search")
    public String searchGameManagement(@RequestParam String keyword,
                                 Model model){
        List<GameManagement> gameManagementList = gameManagementService.getGameManagementsByKeyword(keyword);
        model.addAttribute("gameManagementList", gameManagementList);
        return "gameManagement/list";
    }
}
