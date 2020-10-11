package com.api.covidmicro.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryDTO {

	@JsonProperty("Countries")
	private CountryDetailDTO[] countryDetailDTOs;

	public CountryDetailDTO[] getCountryDetailDTOs() {
		return countryDetailDTOs;
	}

	public void setCountryDetailDTOs(CountryDetailDTO[] countryDetailDTOs) {
		this.countryDetailDTOs = countryDetailDTOs;
	}

	@Override
	public String toString() {
		return "SummaryDTO [countryDetailDTOs=" + Arrays.toString(countryDetailDTOs) + "]";
	}

}
