package actions;

import java.util.List;

import org.openqa.selenium.json.Json;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Clans {
	//https://api.clashroyale.com/v1/clans?name=The%20resistance&locationId=57000038
	private String TOKEN;
	private String clanName;
	private String locationId;
	private String URL;
	private String tag;
	private String name = "The resistance";

	public Clans (String TOKEN, String clanName, String locationId, String tag) {
		this.TOKEN = TOKEN;
		this.clanName = clanName;
		this.locationId = locationId;
		this.tag = tag;
		
	}
	
	public void getClan() {
		URL = "https://api.clashroyale.com/v1/clans?name="+clanName+"&locationId="+locationId;
		String information = Unirest.get(URL)
				.header("Accept", "application/json")
				.header("authorization", "Bearer "+TOKEN)
				.asString()
				.getBody();
		
		JSONObject objAllClans= new JSONObject(information);
		JSONArray arrAllClans = objAllClans.getJSONArray("items");
		
		
		for(Object clans:arrAllClans) {
			JSONObject clan = (JSONObject) clans;
			
			if (clan.getString("name").contentEquals(name) && clan.getString(tag).contains("#9V2Y")){
				System.out.println(clan);
			}
			
			/*System.out.println(clans);
			System.out.println("----------------------------------------");
			
			System.out.println("AAAAAAAAAAAAAAA");
			System.out.println(obj);*/
		}
		
	
			/*JSONObject clan = new JSONObject(clans.toString());
			JSONArray arrClansNames = clan.getJSONArray("name");
			
			for(Object names:arrClansNames) {
				System.out.print(names);
			}*/
		}
		
}

