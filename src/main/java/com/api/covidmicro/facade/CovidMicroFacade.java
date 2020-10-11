package com.api.covidmicro.facade;

import com.api.covidmicro.dto.CasesRangeDTO;
import com.api.covidmicro.dto.CountryDTO;
import com.api.covidmicro.dto.CountryDetailDTO;
import com.api.covidmicro.dto.WorldDTO;

public interface CovidMicroFacade {

	public CountryDTO[] getCountriesList();

	public WorldDTO getTotalWorldData();

	public CountryDetailDTO getDataByCountry(String iso);

	public CasesRangeDTO[] getEachDayCasesByCountry(String slug);

	public CountryDetailDTO[] getCovidSafeCountries();

}
