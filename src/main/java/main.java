import java.io.IOException;

import actions.Clans;
import actions.GenerateKey;
import actions.Locations;
import actions.Members;
import configuracao.DriverFactory;

public class main {

	public static void main(String[] args) throws InterruptedException, IOException {

		DriverFactory driver = new DriverFactory();
		driver.setDriver("https://developer.clashroyale.com/#/");

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

	}
}
