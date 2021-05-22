package com.example.demo.controllers;

import com.example.demo.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;
    @GetMapping("/")
    public String home(Model model)
    {
        int totalnew=coronaVirusDataService.getAllStats().stream().mapToInt(stat->stat.getDiffFromPrevDay()).sum();
        model.addAttribute("totalReportedCases",String.valueOf(coronaVirusDataService.getTotalCases()));
        model.addAttribute("totalnewcases",totalnew);
        model.addAttribute("locationStats",coronaVirusDataService.getAllStats());
        return "home";
    }
}
