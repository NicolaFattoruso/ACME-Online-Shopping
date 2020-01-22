package is.acmeshopping.main;
import is.acmeshopping.entity.*;
import java.util.*;
import is.acmeshopping.entity.Carrello;

import is.acmeshopping.control.*;
public class Main {

	public static void main(String[] args) {

		final int DASH = 0;
		final int ORALB = 1;
		final int SVELTO = 2;
		final int STANHOME = 3;



		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		//Aggiunta prodotti all'inventario
		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "OralB", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "StanHome", "Sgrassatore", 1.10f,  20);
		//

		//Aggiunta Clienti
		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		final int GERARDO = 0;
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");
		final int ANTONIO = 1;
		gCliente.creaCliente("Mario", "admin", "3348698428", "5333-1710-4387-4213");
		final int MARIO = 2;
		gCliente.creaCliente("Carmine", "password", "3338596823", "5333-1710-9876-32345");
		final int CARMINE = 3;
		//

		try {
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2),
					new QuantitaProdotti(gNegozio.getProdotto(ORALB), 3)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(STANHOME), 4),
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello() , 0); 			
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello2.getCarrello() , 1);
			gCliente.faiSpesa(gCliente.getCliente(MARIO), carrello2.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(CARMINE), carrello2.getCarrello(), 2);


			ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

			for(Report report : reports)
			{
				System.out.println(report);
			}
		}
		catch(AcmeException e){
			e.printStackTrace();
		}
	}
}
