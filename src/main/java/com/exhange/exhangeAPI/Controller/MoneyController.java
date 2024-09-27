package com.exhange.exhangeAPI.Controller;

import com.exhange.exhangeAPI.Entity.MoneyEntity;
import com.exhange.exhangeAPI.Repositories.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {

    @Autowired
    public MoneyRepository moneyRepository;

    @GetMapping("/rate/getallrates")
    public String getAllRates(Model model) {
        model.addAttribute("moneyEntities", moneyRepository.getAllMoneys());
        return "allRates";
    }

    @GetMapping("/rate/getoneratebymoneyname")
    public String getOneRateByMoneyName(@RequestParam("moneyName") String moneyName, Model model) {
        MoneyEntity moneyEntity = moneyRepository.getMoneyByName(moneyName);
        model.addAttribute("moneyEntity", moneyEntity);
        return "form";
    }
}
