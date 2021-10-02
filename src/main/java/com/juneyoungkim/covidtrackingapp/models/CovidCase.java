package com.juneyoungkim.covidtrackingapp.models;

public class CovidCase {
	private String provinceState;
    private String countryRegion;
    private int latestTotalCases;
    private int prevDayCases;
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

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    public int getPrevDayCases() {
		return prevDayCases;
	}

	public void setPrevDayCases(int prevDayCases) {
		this.prevDayCases = prevDayCases;
	}

	@Override
    public String toString() {
        return "LocationStats{" +
                "province/state='" + provinceState + '\'' +
                ", country/region='" + countryRegion + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
