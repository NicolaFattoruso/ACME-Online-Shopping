package is.acmeshopping.entity;

import java.util.ArrayList;


public class Carrello {

	private ArrayList<QuantitaProdotti> carrello;


	public Carrello(){
		this.carrello = new ArrayList<QuantitaProdotti>();
	}

	/**
	 * Funzione che incapsula l'aggiunta del prodotto al carrello
	 * @param prodotto è il prodotto che si deridera acquistare
	 * @param quantita è la quantita da acquistare, deve essere superiore alla quantita 
	 * disponibile del prodotto
	 * @throws AcmeException viene invocata se si tenta di acquistare prodotti non disponibili
	 */
	public void aggiungiAlCarrello(Prodotto prodotto, int quantita) throws AcmeException
	{
		if(prodotto.getQuantitaDisp() - quantita < 0)
		{
			throw new AcmeException("Quantita richiesta non disponibile");
		}
		else {
			prodotto.setQuantitaDisp( prodotto.getQuantitaDisp()-quantita );
			this.carrello.add( new QuantitaProdotti(prodotto,quantita) );
		}

	}
	
	public ArrayList<QuantitaProdotti> getCarrello()
	{
		return this.carrello;
	}

}
