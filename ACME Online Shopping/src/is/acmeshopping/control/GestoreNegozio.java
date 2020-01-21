package is.acmeshopping.control;
import is.acmeshopping.entity.*;
import java.util.*;

/**
 * Classe che gestisce il negozio, incluso l'inventario
 * @author nicola
 *
 */
public class GestoreNegozio {

	private ArrayList<Prodotto> listaProdotti;


	public GestoreNegozio()
	{
		listaProdotti = new ArrayList<Prodotto>();
	}

	/**
	 * Funzione che crea ed inserisce un prodotto nella lista dei prodotti
	 * @param codice del prodotto
	 * @param nome del prodotto
	 * @param descrizione del prodotto
	 * @param prezzo del singolo prodotto
	 * @param quantitaDisp è la quantità del prodotto da inserire
	 */
	public void inserisciProdotto(int codice, String nome, String descrizione,
			float prezzo, int quantitaDisp) 
	{
		this.listaProdotti.add( new Prodotto(codice, nome, descrizione, prezzo, quantitaDisp) );
	}

	
	/**
	 * Produce una serie di Report sulla spesa dei clienti
	 * @param N è il numero minimo di spesa affinchè venga generato un report
	 * @param listaClienti è la lista dei clienti dalla quale si vuole generare il report
	 * @return Ritorna un' ArrayList di Report generati
	 */
	public ArrayList<Report> generaReport(int N, ArrayList<Cliente> listaClienti)
	{
		boolean found = false;
		ArrayList<Report> reports = new ArrayList<Report>();
		for( Cliente cliente : listaClienti)
		{
			if(cliente.getListaSpese().size() >= N)
			{
				found = true;
				reports.add(new Report(cliente.getListaSpese().size(), cliente, getImportoComplessivo(cliente)));
			}
		}
		if(!found)
		{
			System.out.println("Non ho nulla da reportare!");
		}
		return reports;
	}



	/**
	 * Funzione per il calcolo della spesa di un dato cliente
	 * @param cliente per la quale si vuole calcolare la spesa
	 * @return Ritorna l'importo complessivo della spesa come float
	 */
	public float getImportoComplessivo(Cliente cliente)
	{
		float importo = 0.0f;
		for(Spesa spesa : cliente.getListaSpese())
		{
			importo += spesa.getCosto();
		}
		return importo;
	}
	
	/**
	 * Funzione per semplificare la ricerca all'interno della lista [vedi @return]
	 * @param index è l'indice in cui risiede il prodotto desiderato nella lista
	 * @return Ritorna il prodotto all'indice @index dalla lista dei prodotti
	 */
	public Prodotto getProdotto(int index)
	{
		return this.listaProdotti.get(index);
	}
	
	public ArrayList<Prodotto> getListaProdotti() {
		return this.listaProdotti;
	}


}
