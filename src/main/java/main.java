import actions.Clans;
import actions.GenerateKey;
import actions.Locations;
import actions.Members;
import configuracao.DriverFactory;

public class main {

	public static void main(String[] args) throws InterruptedException {

		DriverFactory driver = new DriverFactory();
		driver.setDriver("https://developer.clashroyale.com/#/");

		GenerateKey generateKey = new GenerateKey();
		generateKey.login();
		generateKey.generateKey();
		String TOKEN = generateKey.getToken();
		Clans clans = new Clans(TOKEN);
		Members members = new Members(TOKEN);
		Locations locations = new Locations(TOKEN);
		String countryId = locations.getLocationId("Brazil");
		if (countryId == null) {
			System.out.println("Não há nenhum país com esse nome");
		} else {
			String clanTag = clans.getClan("The resistance", countryId, "#9V2Y");
			if (clanTag == null) {
				System.out.println("Não há nenhum clã com esse nome");
			} else {
				members.getMembers(clanTag);
			}
		}

	}
}
