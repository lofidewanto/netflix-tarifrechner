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
        Kunde tempKunde = new Kunde("", 0);

        model.addAttribute("kunde", tempKunde);
        
        return "netflix-tarifrechner";
    }

    @PostMapping("/tarif-rechner")
    public String greetingSubmit(@ModelAttribute Kunde kunde, Model model) {
        Kunde newKunde = new Kunde(kunde.getName(), kunde.getAlter());
        double calculatePreis = netflixTarifRechnerService.calculatePreis(newKunde);

        model.addAttribute("kunde", newKunde);
        model.addAttribute("preis", calculatePreis);

        return "netflix-tarifrechner-result";
    }

}
