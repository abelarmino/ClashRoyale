package actions;

import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Locations {
	String TOKEN;
	public Locations(String TOKEN) {
		this.TOKEN = TOKEN;
	}
	
	public String getLocationId(String country) {
		String URL = "https://api.clashroyale.com/v1/locations";
		String countriesInformation = Unirest.get(URL)
				.header("Accept", "application/json")
				.header("authorization", "Bearer "+TOKEN)
				.asString()
				.getBody();
		JSONObject allCountries = new JSONObject(countriesInformation);
		JSONArray arrAllCountries = allCountries.getJSONArray("items");
		
		for (Object countries:arrAllCountries) {
			JSONObject countryObj = (JSONObject) countries;
			if (countryObj.get("name").toString().equals(country)) {
				System.out.println(countryObj.get("name").toString());
				System.out.println(countryObj.get("id").toString());
				return countryObj.get("id").toString();
			}
		}
		return null;
		
	}


}
