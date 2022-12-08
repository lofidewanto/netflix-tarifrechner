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

    @GetMapping("/tarif-rechner")
    public String greetingForm(Model model) {
        model.addAttribute("kunde", new Kunde(null, 0));
        return "netflix-tarifrechner";
    }

    @PostMapping("/tarif-rechner")
    public String greetingSubmit(@ModelAttribute Kunde kunde, Model model) {
        model.addAttribute("kunde", kunde);

        double calculatePreis = netflixTarifRechnerService.calculatePreis(new Kunde(kunde.getName(), kunde.getAlter()));

        model.addAttribute("preis", calculatePreis);

        return "netflix-tarifrechner-result";
    }

}
