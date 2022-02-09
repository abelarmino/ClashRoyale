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
		Clans clans = new Clans(generateKey.getToken(),"the%20resistance","57000038","#9V2Y");
		clans.getClan();
		
		
	}

}
