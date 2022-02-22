import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import actions.Clans;
import actions.GenerateKey;
import actions.Locations;
import actions.Members;
import actions.Utils;
import configuracao.DriverFactory;

public class main {

	public static void main(String[] args) throws InterruptedException, IOException {

		DriverFactory driver = new DriverFactory();
		driver.setDriver("https://developer.clashroyale.com/#/");
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		Utils.createFolder(dtf.format(LocalDateTime.now()));
		GenerateKey generateKey = new GenerateKey();
		generateKey.login();
		generateKey.generateKey();
		String TOKEN = generateKey.getToken();
		Clans clans = new Clans(TOKEN);
		Members members = new Members(TOKEN);
		
			String clanTag = clans.getClan();
			if (clanTag == null) {
				System.out.println("Não há nenhum clã com esse nome");
			} else {
				members.getMembers(clanTag);
			}
		generateKey.deleteKey();
		driver.killDriver();
	}
}
