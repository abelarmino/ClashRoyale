import actions.Clans;
import actions.GenerateIp;
import actions.GenerateKey;
import configuracao.DriverFactory;


public class main {

	public static void main(String[] args) throws InterruptedException{		
		
		DriverFactory driver = new DriverFactory();
		driver.setDriver("https://developer.clashroyale.com/#/");
		
		GenerateKey generateKey = new GenerateKey();
		generateKey.login();
		generateKey.generateKey();
		Clans clans = new Clans(generateKey.getToken());
		String clanTag = clans.getClan("The resistance","57000038","#9V2Y");
		if (clanTag ==   null) {
			System.out.println("Não há nenhum clã com esse nome");
		} else {
			clans.getMembers(clanTag);
		}
		
		
	}

}
