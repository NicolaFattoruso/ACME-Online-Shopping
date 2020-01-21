package is.acmeshopping.main;
import is.acmeshopping.entity.*;
import java.util.*;
import is.acmeshopping.entity.Carrello;

import is.acmeshopping.control.*;
public class Main {

	public static void main(String[] args) {

		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		//Aggiunta prodotti all'inventario
		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);
		//

		//Aggiunta Clienti
		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");
		gCliente.creaCliente("Mario", "admin", "3348698428", "5333-1710-4387-4213");
		gCliente.creaCliente("Carmine", "password", "3338596823", "5333-1710-9876-32345");
		//


		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();

		try {
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2);
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(1), 3);
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(3), 4);

			gCliente.faiSpesa(gCliente.getListaClienti().get(0), carrello1.getCarrello() , 0); //TOT : 11.50 euro			
			gCliente.faiSpesa(gCliente.getListaClienti().get(1), carrello2.getCarrello() , 1); //TOT : 11.50 euro


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
