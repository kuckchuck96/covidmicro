package com.api.covidmicro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.covidmicro.dao.CovidMicroDao;
import com.api.covidmicro.dto.CasesRangeDTO;
import com.api.covidmicro.dto.CountryDTO;
import com.api.covidmicro.dto.CountryDetailDTO;
import com.api.covidmicro.dto.WorldDTO;
import com.api.covidmicro.facade.CovidMicroFacade;

@Service
public class CovidMicroService implements CovidMicroFacade {

	@Autowired
    CovidMicroDao dao;

    @Override
    public CountryDTO[] getCountriesList() {
        return dao.getCountriesList();
    }

    @Override
    public WorldDTO getTotalWorldData() {
        return dao.getTotalWorldData();
    }

    @Override
    public CountryDetailDTO getDataByCountry(String iso) {
        return dao.getDataByCountry(iso);
    }

    @Override
    public CasesRangeDTO[] getEachDayCasesByCountry(String slug) {
        return dao.getEachDayCasesByCountry(slug);
    }

    @Override
    public CountryDetailDTO[] getCovidSafeCountries() {
        return dao.getCovidSafeCountries();
    }
	
}
