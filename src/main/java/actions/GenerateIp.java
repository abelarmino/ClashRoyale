package actions;

import kong.unirest.Unirest;

public class GenerateIp {
	
	public static String getIp() {
		String url = Unirest.get("https://api.ipify.org/")
				.asString()
				.getBody();
		return url;
	}

}
