package com.api.covidmicro.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String date = "";
		int day = 0;
		int check_day = 0;
		SimpleDateFormat formatter = null;
		// Create day of the month to append 'st', 'nd', 'rd' or 'th' based on day.
		formatter = new SimpleDateFormat("d");
		day = Integer.parseInt(formatter.format(value));
		check_day = day % 10;

		if (check_day == 1) {
			date += day + "st";
		} else if (check_day == 2) {
			date += day + "nd";
		} else if (check_day == 3) {
			date += day + "rd";
		} else {
			date += day + "th";
		}
		// Add month and year to the date
		formatter = new SimpleDateFormat("MMM yyyy");
		date += " " + formatter.format(value);

		gen.writeString(date);
	}

}
