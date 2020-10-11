package com.api.covidmicro.dto;

import java.util.Date;

import com.api.covidmicro.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDetailDTO {

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Slug")
	private String slug;

	@JsonProperty("CountryCode")
	private String iso;

	@JsonProperty("TotalConfirmed")
	private Long totalConfirmed;

	@JsonProperty("TotalDeaths")
	private Long totalDeaths;

	@JsonProperty("TotalRecovered")
	private Long totalRecovered;

	@JsonProperty("Date")
	private Date date;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

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
		return "CountryDetailDTO [country=" + country + ", date=" + date + ", iso=" + iso + ", slug=" + slug
				+ ", totalConfirmed=" + totalConfirmed + ", totalDeaths=" + totalDeaths + ", totalRecovered="
				+ totalRecovered + "]";
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}