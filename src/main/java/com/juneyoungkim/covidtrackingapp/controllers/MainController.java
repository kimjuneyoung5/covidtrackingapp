package com.juneyoungkim.covidtrackingapp.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juneyoungkim.covidtrackingapp.services.CovidTrackingService;
import com.juneyoungkim.covidtrackingapp.models.CovidCase;
import com.juneyoungkim.covidtrackingapp.models.CovidDeath;

@Controller
public class MainController {
	
	@Autowired
	CovidTrackingService covidTrackingServ;
	
	@GetMapping("/")
	public String index(Model model) {
		List<CovidCase> allCasesStats = covidTrackingServ.getAllCasesStats();
        int totalReportedCases = allCasesStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("totalReportedCases", totalReportedCases);
        List<CovidDeath> allDeathsStats = covidTrackingServ.getAllDeathsStats();
        int totalReportedDeaths = allDeathsStats.stream().mapToInt(stat2 -> stat2.getLatestTotalDeaths()).sum();
        model.addAttribute("totalReportedDeaths", totalReportedDeaths);
        
        Map<String, Integer> totalStatsMap = new LinkedHashMap<>();
        totalStatsMap.put("Total Reported Cases", totalReportedCases);
        totalStatsMap.put("Total Reported Deaths", totalReportedDeaths);
        model.addAttribute("totalStatsMap", totalStatsMap);
        
		return "index.jsp";
	}
	
	@GetMapping("/graph")
	public String graph(Model model) {
		List<CovidCase> allCasesStats = covidTrackingServ.getAllCasesStats();
        int totalReportedCases = allCasesStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("totalReportedCases", totalReportedCases);
        List<CovidDeath> allDeathsStats = covidTrackingServ.getAllDeathsStats();
        int totalReportedDeaths = allDeathsStats.stream().mapToInt(stat2 -> stat2.getLatestTotalDeaths()).sum();
        model.addAttribute("totalReportedDeaths", totalReportedDeaths);
        
        Map<String, Integer> totalStatsMap = new LinkedHashMap<>();
        totalStatsMap.put("Total Reported Cases", totalReportedCases);
        totalStatsMap.put("Total Reported Deaths", totalReportedDeaths);
        model.addAttribute("totalStatsMap", totalStatsMap);
        
		return "chart.jsp";
	}
	
	@GetMapping("/cases")
    public String caseHome(Model model) {
        List<CovidCase> allCasesStats = covidTrackingServ.getAllCasesStats();
        int totalReportedCases = allCasesStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allCasesStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("casesStats", allCasesStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        
        return "cases.jsp";
    }
	
	@GetMapping("/deaths")
	public String deathHome(Model model) {
		List<CovidDeath> allDeathsStats = covidTrackingServ.getAllDeathsStats();
        int totalReportedDeaths = allDeathsStats.stream().mapToInt(stat2 -> stat2.getLatestTotalDeaths()).sum();
        int totalNewDeaths = allDeathsStats.stream().mapToInt(stat2 -> stat2.getDiffFromPrevDay()).sum();
        model.addAttribute("deathsStats", allDeathsStats);
        model.addAttribute("totalReportedDeaths", totalReportedDeaths);
        model.addAttribute("totalNewDeaths", totalNewDeaths);

        return "deaths.jsp";
	}
	
}
