package com.api.covidmicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.covidmicro.dto.CasesRangeDTO;
import com.api.covidmicro.dto.CountryDTO;
import com.api.covidmicro.dto.CountryDetailDTO;
import com.api.covidmicro.dto.WorldDTO;
import com.api.covidmicro.facade.CovidMicroFacade;
import com.api.covidmicro.service.CovidMicroService;

@RestController
public class CovidMicroController implements CovidMicroFacade {

	@Autowired
	CovidMicroService service;

	@CrossOrigin
	@GetMapping("/countries")
	@Override
	public CountryDTO[] getCountriesList() {
		return service.getCountriesList();
	}

	@CrossOrigin
	@GetMapping("/total")
	@Override
	public WorldDTO getTotalWorldData() {
		return service.getTotalWorldData();
	}

	@CrossOrigin
	@GetMapping("/country")
	@Override
	public CountryDetailDTO getDataByCountry(@RequestParam String iso) {
		return service.getDataByCountry(iso);
	}

	@CrossOrigin
	@GetMapping("/country/range")
	@Override
	public CasesRangeDTO[] getEachDayCasesByCountry(String slug) {
		return service.getEachDayCasesByCountry(slug);
	}

	@CrossOrigin
	@GetMapping("/countries/safe")
	@Override
	public CountryDetailDTO[] getCovidSafeCountries() {
		return service.getCovidSafeCountries();
	}

}
