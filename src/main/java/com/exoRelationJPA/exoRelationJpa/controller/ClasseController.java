package com.exoRelationJPA.exoRelationJpa.controller;

import com.exoRelationJPA.exoRelationJpa.model.Classe;
import com.exoRelationJPA.exoRelationJpa.service.ClasseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classe")
public class ClasseController {
    private ClasseService classeService;

    public ClasseController (ClasseService classeService){
        this.classeService = classeService;
    }
    @GetMapping("/")
    public String getAllClasse (Model model){
        model.addAttribute("models",classeService.getAllArticle());
        return "index";
    }
    @GetMapping("/{id}")
    public String findClasseById (Model model,@PathVariable Long id){
        model.addAttribute("model",classeService.findClasseById(id));
        return "detail";
    }
    @GetMapping("/new")
    public String getFormNewClasse(Model model) {
        model.addAttribute("classe", new Classe());
        return "form";
    }
    @PostMapping("/new")
    public String newClasse (@ModelAttribute Classe newClasse, Model model){
        classeService.createNewClasse(newClasse);
        return "redirect:/";
    }
    @GetMapping("/{id}/modifier")
    public String getFormModifyClasse(@PathVariable Long id,Model model) {
        Classe classe = classeService.findClasseById(id);
        if (classe != null){
            model.addAttribute("classe", classe);
            return "form";
        }
        return "redirect:/";
    }
    @PostMapping("/{id}/modifier")
    public String modifierClasse(@PathVariable Long id, @ModelAttribute Classe classe) {
        classe.setId(id);
        classeService.modifyClasse(classe);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteClasse (@PathVariable Long id){
        classeService.deleteClasse(id);
        return "redirect:/";
    }
}
