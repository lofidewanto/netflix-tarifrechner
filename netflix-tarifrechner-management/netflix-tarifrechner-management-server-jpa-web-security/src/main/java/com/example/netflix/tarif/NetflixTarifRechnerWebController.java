package com.example.netflix.tarif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NetflixTarifRechnerWebController {

    @Autowired
    private NetflixTarifRechnerService netflixTarifRechnerService;

    @GetMapping("/netflix-tarifrechner")
    public String showTarifRechner(Model model) {
        model.addAttribute("kunde", new Kunde("", 0));
        return "netflix-tarifrechner";
    }

    @PostMapping("/netflix-tarifrechner")
    public String submitTarifRechner(@ModelAttribute Kunde kunde, Model model) {
        double calculatePreis = netflixTarifRechnerService.calculatePreis(kunde);
        model.addAttribute("kunde", kunde);
        model.addAttribute("preis", calculatePreis);
        return "netflix-tarifrechner-result";
    }
}
