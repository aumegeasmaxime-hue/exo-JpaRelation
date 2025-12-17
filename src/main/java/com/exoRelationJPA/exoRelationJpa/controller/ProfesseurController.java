package com.exoRelationJPA.exoRelationJpa.controller;

import com.exoRelationJPA.exoRelationJpa.model.Professeur;
import com.exoRelationJPA.exoRelationJpa.service.ProfesseurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professeurs")
public class ProfesseurController {
    private ProfesseurService professeurService;

    public ProfesseurController (ProfesseurService professeurService){
        this.professeurService = professeurService;
    }
    @GetMapping("/")
    public String getAllProfesseur (Model modelP){
        modelP.addAttribute("models",professeurService.getAllProfesseur());
        return "/professeurs/index";
    }
    @GetMapping("/{id}")
    public String findProfesseurById (Model modelP,@PathVariable Long id){
        modelP.addAttribute("modelP",professeurService.findProfesseurById(id));
        modelP.addAttribute("nbClasse",professeurService.countClasses(id));
        modelP.addAttribute("nbEleve",professeurService.countEleves(id));
        return "/professeurs/details";
    }
    @GetMapping("/new")
    public String getFormNewProfesseur(Model model) {
        model.addAttribute("professeur", new Professeur());
        return "/professeurs/form";
    }
    @PostMapping("/new")
    public String newProfesseur (@ModelAttribute Professeur newProfesseur, Model model){
        professeurService.createNewProfesseur(newProfesseur);
        return "redirect:/professeurs/";
    }
    @GetMapping("/{id}/modifier")
    public String getFormModifyProfesseur(@PathVariable Long id,Model model) {
        Professeur professeur = professeurService.findProfesseurById(id);
        if (professeur != null){
            model.addAttribute("professeur", professeur);
            return "/professeurs/form";
        }
        return "redirect:/professeurs/";
    }
    // /professeurs/1/modifier
    @PostMapping("/{id}/modifier")
    public String modifierProfesseur(@PathVariable Long id, @ModelAttribute Professeur professeur) {
        professeur.setId(id);
        professeurService.modifyProfesseur(professeur);
        return "redirect:/professeurs/";
    }
    @GetMapping("/{id}/delete")
    public String deleteProfesseur (@PathVariable Long id){
        professeurService.deleteProfesseur(id);
        return "redirect:/professeurs/";
    }
}
