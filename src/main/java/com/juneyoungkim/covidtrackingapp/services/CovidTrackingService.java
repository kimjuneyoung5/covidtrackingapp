package com.juneyoungkim.covidtrackingapp.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.juneyoungkim.covidtrackingapp.models.CovidCase;
import com.juneyoungkim.covidtrackingapp.models.CovidDeath;

@Service
public class CovidTrackingService {
	
private static String COVID_CASES_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
private static String COVID_DEATHS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";


	private List<CovidCase> allCasesStats = new ArrayList<>();

    public List<CovidCase> getAllCasesStats() {
        return allCasesStats;
    }
    
    private List<CovidDeath> allDeathsStats = new ArrayList<>();
    
    public List<CovidDeath> getAllDeathsStats() {
    	return allDeathsStats;
    }
    
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchCovidCaseData() throws IOException, InterruptedException {
		List<CovidCase> newCasesStats = new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(COVID_CASES_DATA_URL))
				.build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(httpResponse.body());
		StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> caseRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord caseRecord : caseRecords) {
            CovidCase covidCaseStat = new CovidCase();
            covidCaseStat.setProvinceState(caseRecord.get("Province/State"));
            covidCaseStat.setCountryRegion(caseRecord.get("Country/Region"));
            //System.out.println(locationStat.getProvinceState());
            //System.out.println(locationStat.getCountryRegion());
            int latestCases = Integer.parseInt(caseRecord.get(caseRecord.size() - 1));
            int prevDayCases = Integer.parseInt(caseRecord.get(caseRecord.size() - 2));
            covidCaseStat.setLatestTotalCases(latestCases);
            covidCaseStat.setPrevDayCases(prevDayCases);
            covidCaseStat.setDiffFromPrevDay(latestCases - prevDayCases);
            newCasesStats.add(covidCaseStat);
        }
        this.allCasesStats = newCasesStats;
		
	}
	
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchCovidDeathData() throws IOException, InterruptedException {
		List<CovidDeath> newDeathsStats = new ArrayList<>();
		HttpClient client2 = HttpClient.newHttpClient();
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create(COVID_DEATHS_DATA_URL))
				.build();
		HttpResponse<String> httpResponse2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
		StringReader csvBodyReader2 = new StringReader(httpResponse2.body());
		Iterable<CSVRecord> deathRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader2);
		for (CSVRecord deathRecord : deathRecords) {
			CovidDeath covidDeathStat = new CovidDeath();
			covidDeathStat.setProvinceState(deathRecord.get("Province/State"));
			covidDeathStat.setCountryRegion(deathRecord.get("Country/Region"));
			int latestDeaths = Integer.parseInt(deathRecord.get(deathRecord.size() - 1));
			int prevDaysDeaths = Integer.parseInt(deathRecord.get(deathRecord.size() - 2));
            covidDeathStat.setLatestTotalDeaths(latestDeaths);
            covidDeathStat.setPrevDayDeaths(prevDaysDeaths);
            covidDeathStat.setDiffFromPrevDay(latestDeaths - prevDaysDeaths);
            newDeathsStats.add(covidDeathStat);
		}
		this.allDeathsStats = newDeathsStats;
	}
}
