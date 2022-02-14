package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Clans {
	// https://api.clashroyale.com/v1/clans?name=The%20resistance&locationId=57000038
	private String TOKEN;
	private String country;
	private String clanName;
	private String locationId;
	private String tag;
	private String name;
	private Locations location;
	private static final String fileName = "C:/Projects/ClashRoyale/src/resources/massa.xls";

	public Clans(String TOKEN) throws IOException {
		this.TOKEN = TOKEN;
		location = new Locations(TOKEN);
		FileInputStream file = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheetClans = workbook.getSheetAt(2);
		Iterator<Row> rowIterator = sheetClans.iterator();
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch(cell.getColumnIndex()) {
					case 0:
						name = cell.getStringCellValue();
						break;
					case 1:
						tag = cell.getStringCellValue();
						break;
					case 2:
						country = cell.getStringCellValue();
						break;
				}
			}
		}	

	}

	public String getClan() {
		locationId = location.getLocationId(country);
		if (locationId == null) {
			System.out.println("Não há nenhum país com esse nome");
		} else {
		String URL = "https://api.clashroyale.com/v1/clans?name=" + name.replaceAll("[ ]", "%20") + "&locationId=" + locationId;
		String information = Unirest.get(URL).header("Accept", "application/json")
				.header("authorization", "Bearer " + TOKEN).asString().getBody();

		JSONObject objAllClans = new JSONObject(information);
		JSONArray arrAllClans = objAllClans.getJSONArray("items");

		for (Object clans : arrAllClans) {
			JSONObject clan = (JSONObject) clans;
			if (clan.getString("name").contentEquals(name) && clan.getString("tag").contains(this.tag)) {
				System.out.println(clan);
				return clan.getString("tag");

			}

		}
		}
		return null;
	}

}
