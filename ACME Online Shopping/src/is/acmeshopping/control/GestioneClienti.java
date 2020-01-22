package is.acmeshopping.control;
import is.acmeshopping.entity.*;
import java.util.*;

/**
 * Classe che gestisce i clienti del negozio
 * @author nicola
 *
 */
public class GestioneClienti {

	private LinkedList<Cliente> listaClienti;



	public GestioneClienti()
	{
		this.listaClienti = new LinkedList<Cliente>();
	}




	/**
	 * Simula l'azione del fare la spesa per un dato cliente e la sua "lista della spesa" 
	 * @param cliente è il cliente che farà la spesa
	 * @param listaQuantitaProdotti rappresenta la "lista della spesa", 
	 * è un ArrayList di QuantitaProdotti, che contiene il prodotto e la quantita da comprare 
	 * @param ID è l'ID della spesa
	 */
	public void faiSpesa(Cliente cliente, ArrayList<QuantitaProdotti> listaQuantitaProdotti, int ID)
	{
		Date data = java.util.Calendar.getInstance().getTime(); //gets current date
		Spesa spesa = new Spesa(ID, data, listaQuantitaProdotti);
		cliente.addSpesa(spesa);
	}



	/**
	 * Aggiunge un cliente alla lista dei Clienti
	 * @param nomeUtente è il nome del cliente da aggiungere
	 * @param password è la password del cliente
	 * @param numTelefono è il numero di telefono del cliente
	 * @param cartaDiCredito è la carta di credito del cliente
	 */
	public void creaCliente( String nomeUtente, String password, String numTelefono, String cartaDiCredito)
	{
		this.listaClienti.add(new Cliente(nomeUtente, password, numTelefono, cartaDiCredito));
	}
	
	/**
	 * Funzione per semplificare la ricerca all'interno della lista [vedi @return]
	 * @param index è l'indice in cui risiede il cliente desiderato nella lista
	 * @return Ritorna il cliente all'indice @index dalla lista dei clienti
	 */
	public Cliente getCliente(int index)
	{
		return this.listaClienti.get(index);
	}
	
	public LinkedList<Cliente> getListaClienti()
	{
		return this.listaClienti;
	}

}
