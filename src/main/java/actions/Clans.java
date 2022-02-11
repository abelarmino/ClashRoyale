package actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.json.Json;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Clans {
	// https://api.clashroyale.com/v1/clans?name=The%20resistance&locationId=57000038
	private String TOKEN;
	private String clanName;
	private String locationId;
	private String tag;
	private String name = "The resistance";
	
	public Clans(String TOKEN) {
		this.TOKEN = TOKEN;

	}

	public String getClan(String clanName, String locationId, String tag) {
		this.clanName = clanName.replaceAll("[ ]", "%20");
		this.locationId = locationId;
		this.tag = tag;
		String URL = "https://api.clashroyale.com/v1/clans?name=" + clanName + "&locationId=" + locationId;
		String information = Unirest.get(URL).header("Accept", "application/json")
				.header("authorization", "Bearer " + TOKEN).asString().getBody();

		JSONObject objAllClans = new JSONObject(information);
		JSONArray arrAllClans = objAllClans.getJSONArray("items");

		for (Object clans : arrAllClans) {
			JSONObject clan = (JSONObject) clans;

			if (clan.getString("name").contentEquals(name) && clan.getString("tag").contains(tag)) {
				System.out.println(clan);
				return clan.getString("tag");

			}

		}

		return null;
	}

}
