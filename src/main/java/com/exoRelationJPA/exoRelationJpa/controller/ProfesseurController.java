package com.exoRelationJPA.exoRelationJpa.controller;

import com.exoRelationJPA.exoRelationJpa.model.Professeur;
import com.exoRelationJPA.exoRelationJpa.service.ProfesseurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {
    private ProfesseurService professeurService;

    public ProfesseurController (ProfesseurService professeurService){
        this.professeurService = professeurService;
    }
    @GetMapping("/")
    public String getAllProfesseur (Model model){
        model.addAttribute("models",professeurService.getAllArticle());
        return "index";
    }
    @GetMapping("/{id}")
    public String findProfesseurById (Model model,@PathVariable Long id){
        model.addAttribute("model",professeurService.findProfesseurById(id));
        return "detail";
    }
    @GetMapping("/new")
    public String getFormNewProfesseur(Model model) {
        model.addAttribute("professeur", new Professeur());
        return "form";
    }
    @PostMapping("/new")
    public String newProfesseur (@ModelAttribute Professeur newProfesseur, Model model){
        professeurService.createNewProfesseur(newProfesseur);
        return "redirect:/";
    }
    @GetMapping("/{id}/modifier")
    public String getFormModifyProfesseur(@PathVariable Long id,Model model) {
        Professeur professeur = professeurService.findProfesseurById(id);
        if (professeur != null){
            model.addAttribute("professeur", professeur);
            return "form";
        }
        return "redirect:/";
    }
    @PostMapping("/{id}/modifier")
    public String modifierProfesseur(@PathVariable Long id, @ModelAttribute Professeur professeur) {
        professeur.setId(id);
        professeurService.modifyProfesseur(professeur);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteProfesseur (@PathVariable Long id){
        professeurService.deleteProfesseur(id);
        return "redirect:/";
    }
}
