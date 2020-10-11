package com.api.covidmicro.dto;

import java.util.Date;

import com.api.covidmicro.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorldDTO {

	@JsonProperty("TotalConfirmed")
	private Long totalConfirmed;

	@JsonProperty("TotalDeaths")
	private Long totalDeaths;

	@JsonProperty("TotalRecovered")
	private Long totalRecovered;

	private Date date = new Date();

	public Long getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Long totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public Long getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Long getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Long totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	@Override
	public String toString() {
		return "WorldDTO [totalConfirmed=" + totalConfirmed + ", totalDeaths=" + totalDeaths + ", totalRecovered="
				+ totalRecovered + "]";
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}

}
