package com.api.covidmicro.dao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.api.covidmicro.dto.CasesRangeDTO;
import com.api.covidmicro.dto.CountryDTO;
import com.api.covidmicro.dto.CountryDetailDTO;
import com.api.covidmicro.dto.SummaryDTO;
import com.api.covidmicro.dto.WorldDTO;
import com.api.covidmicro.facade.CovidMicroFacade;
import com.api.covidmicro.util.GlobalValues;

@Repository
public class CovidMicroDao implements CovidMicroFacade {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public CountryDTO[] getCountriesList() {
		ResponseEntity<CountryDTO[]> responseEntity = restTemplate.getForEntity(GlobalValues.COUNTRIES,
				CountryDTO[].class);

		CountryDTO[] countryDTOs = responseEntity.getBody();

		Optional<CountryDTO[]> checkEntity = Optional.ofNullable(countryDTOs);

		if (checkEntity.isPresent()) {
			return responseEntity.getBody();
		}

		return new CountryDTO[0];
	}

	@Override
	public WorldDTO getTotalWorldData() {
		ResponseEntity<WorldDTO> responseEntity = restTemplate.getForEntity(GlobalValues.WORLD_DATA,
				WorldDTO.class);

		WorldDTO worldDTO = responseEntity.getBody();

		Optional<WorldDTO> checkEntity = Optional.ofNullable(worldDTO);

		if (checkEntity.isPresent()) {
			return worldDTO;
		}

		return null;
	}

	@Override
	public CountryDetailDTO getDataByCountry(String iso) {
		ResponseEntity<SummaryDTO> responseEntity = restTemplate.getForEntity(GlobalValues.COUNTRY_DATA,
				SummaryDTO.class);

		SummaryDTO summaryDTO = responseEntity.getBody();

		Optional<SummaryDTO> checkEntity = Optional.ofNullable(summaryDTO);

		if (checkEntity.isPresent()) {
			return Arrays.asList(summaryDTO.getCountryDetailDTOs()).stream().filter(c -> c.getIso().equals(iso))
					.findAny().orElse(null);
		}

		return null;
	}

	@Override
	public CasesRangeDTO[] getEachDayCasesByCountry(String slug) {
		Date date = new Date();
		SimpleDateFormat formatter = null;
		String fromDate = null;
		String toDate = null;
		int day = 0;

		/*
		 * Check day of the month. Return nothing if its a first day of the month
		 */
		formatter = new SimpleDateFormat("d");
		day = Integer.parseInt(formatter.format(date));
		if (day == 1) {
			return null;
		}

		formatter = new SimpleDateFormat("yyyy-MM-01");
		fromDate = formatter.format(date);

		// --day;
		formatter = new SimpleDateFormat(day > 9 ? "yyyy-MM-" + day : "yyyy-MM-0" + day);
		toDate = formatter.format(date);

		/**
		 * Get result set from API.
		 */
		ResponseEntity<CasesRangeDTO[]> responseEntity = restTemplate
				.getForEntity("https://api.covid19api.com/total/country/" + slug + "/status/confirmed?from=" + fromDate
						+ "&to=" + toDate, CasesRangeDTO[].class);

		CasesRangeDTO[] casesRangeDTOs = responseEntity.getBody();

		if (responseEntity.getStatusCode() == HttpStatus.OK && casesRangeDTOs.length > 0) {
			return casesRangeDTOs;
		}

		return null;
	}

	/**
	 * This is similar to extracting details of cases in countries. Its just we have
	 * to filter out which are safe based on TotalConfirmed == TotalRecovered.
	 */
	@Override
	public CountryDetailDTO[] getCovidSafeCountries() {
		ResponseEntity<SummaryDTO> responseEntity = restTemplate.getForEntity("https://api.covid19api.com/summary",
				SummaryDTO.class);

		SummaryDTO summaryDTO = responseEntity.getBody();

		Optional<SummaryDTO> checkEntity = Optional.ofNullable(summaryDTO);

		if (checkEntity.isPresent()) {

			return Arrays.stream(summaryDTO.getCountryDetailDTOs())
					.filter(c -> c.getTotalConfirmed() == c.getTotalRecovered()).toArray(CountryDetailDTO[]::new);

		}

		return null;
	}

}
