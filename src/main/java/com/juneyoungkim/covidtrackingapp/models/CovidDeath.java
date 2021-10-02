package com.juneyoungkim.covidtrackingapp.models;

public class CovidDeath {
	private String provinceState;
    private String countryRegion;
    private int latestTotalDeaths;
    private int prevDayDeaths;
    private int diffFromPrevDay;

    public int getDiffFromPrevDay() {
        return diffFromPrevDay;
    }

    public void setDiffFromPrevDay(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }

    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public int getLatestTotalDeaths() {
        return latestTotalDeaths;
    }

    public void setLatestTotalDeaths(int latestTotalDeaths) {
        this.latestTotalDeaths = latestTotalDeaths;
    }

    public int getPrevDayDeaths() {
		return prevDayDeaths;
	}

	public void setPrevDayDeaths(int prevDayDeaths) {
		this.prevDayDeaths = prevDayDeaths;
	}

	@Override
    public String toString() {
        return "LocationStats{" +
                "province/state='" + provinceState + '\'' +
                ", country/region='" + countryRegion + '\'' +
                ", latestTotalCases=" + latestTotalDeaths +
                '}';
	}
}
