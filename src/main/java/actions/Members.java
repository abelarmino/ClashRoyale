package actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Members {
	String TOKEN;
	private static final String fileName = "C:/Projects/ClashRoyale/src/resources/members.xls";

	
	public Members(String TOKEN) {
		this.TOKEN = TOKEN;
	}
	public void getMembers(String tag) {
		tag = tag.replaceAll("[#]", "%23");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetMembers = workbook.createSheet("Members");
		
		String URL="https://api.clashroyale.com/v1/clans/"+tag+"/members"; 
		String membersInformation = Unirest.get(URL)
				.header("Accept", "application/json")
				.header("authorization", "Bearer "+TOKEN)
				.asString()
				.getBody();
		JSONObject allMembers = new JSONObject(membersInformation);
		JSONArray arrAllMembers = allMembers.getJSONArray("items");
		int rowNum = 0;
		for(Object members:arrAllMembers) {
			JSONObject member = (JSONObject) members;
			Row row = sheetMembers.createRow(rowNum++);
			int cellNum = 0;
			Cell cellName = row.createCell(cellNum++);
			cellName.setCellValue(member.get("name").toString());
			Cell cellExpLvl = row.createCell(cellNum++);
			cellExpLvl.setCellValue(member.get("expLevel").toString());
			Cell cellTrophies = row.createCell(cellNum++);
			cellTrophies.setCellValue(member.get("trophies").toString());
			Cell cellRole = row.createCell(cellNum++);
			cellRole.setCellValue(member.get("role").toString());
			System.out.println(member.get("name"));
		}
		try {
			FileOutputStream out = 
					new FileOutputStream(new File (fileName));
			workbook.write(out);
			out.close();
			System.out.println("Arquivo criado com sucesso!");

		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo");

		}
	}
	
}
