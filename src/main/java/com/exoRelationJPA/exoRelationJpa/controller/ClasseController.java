package com.exoRelationJPA.exoRelationJpa.controller;

import com.exoRelationJPA.exoRelationJpa.model.Classe;
import com.exoRelationJPA.exoRelationJpa.service.ClasseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClasseController {
    private ClasseService classeService;

    public ClasseController (ClasseService classeService){
        this.classeService = classeService;
    }
    @GetMapping("/")
    public String getAllClasse (Model model){
        model.addAttribute("models",classeService.getAllArticle());
        return "/classes/index";
    }
    @GetMapping("/{id}")
    public String findClasseById (Model model,@PathVariable Long id){
        model.addAttribute("model",classeService.findClasseById(id));
        return "/classes/details";
    }
    @GetMapping("/new")
    public String getFormNewClasse(Model model) {
        model.addAttribute("classe", new Classe());
        return "/classes/form";
    }
    @PostMapping("/new")
    public String newClasse (@ModelAttribute Classe newClasse, Model model){
        classeService.createNewClasse(newClasse);
        return "redirect:/classes/";
    }
    @GetMapping("/{id}/modifier")
    public String getFormModifyClasse(@PathVariable Long id,Model model) {
        Classe classe = classeService.findClasseById(id);
        if (classe != null){
            model.addAttribute("classe", classe);
            return "/classes/form";
        }
        return "redirect:/classes/";
    }
    @PostMapping("/{id}/modifier")
    public String modifierClasse(@PathVariable Long id, @ModelAttribute Classe classe) {
        classe.setId(id);
        classeService.modifyClasse(classe);
        return "redirect:/classes/";
    }
    @GetMapping("/{id}/delete")
    public String deleteClasse (@PathVariable Long id){
        classeService.deleteClasse(id);
        return "redirect:/classes/";
    }
}
