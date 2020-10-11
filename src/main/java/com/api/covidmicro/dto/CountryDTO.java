package com.api.covidmicro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDTO {

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Slug")
	private String slug;

	@JsonProperty("ISO2")
	private String iso;

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

	@Override
	public String toString() {
		return "CountryDTO [country=" + country + ", iso=" + iso + ", slug=" + slug + "]";
	}

}
