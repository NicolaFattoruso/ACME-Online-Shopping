package is.acmeshopping.entity;

import java.util.ArrayList;

public class Cliente {

	private String nomeUtente;
	private String password;
	private String numTelefono;
	private String cartaDiCredito;
	private ArrayList<Spesa> listaSpese;


	public Cliente(String nomeUtente, String password, String numTelefono,
			String cartaDiCredito) {

		this.nomeUtente = nomeUtente;
		this.password = password;
		this.numTelefono = numTelefono;
		this.cartaDiCredito = cartaDiCredito;
		this.listaSpese = new ArrayList<Spesa>();
	}

	/**
	 * Aggiunge una spesa alla lista delle spese del cliente
	 * @param spesa è la spesa da aggiungere
	 */
	public void addSpesa(Spesa spesa)
	{
		this.listaSpese.add(spesa);
	}

	/**
	 * Funzione che sovrascrive il meotodo equals per confrontare due clienti 
	 */
	public boolean equals(Object o) {
		Cliente cliente = (Cliente) o;
		if(
				this.nomeUtente.equals(cliente.getNomeUtente() ) && 
				this.password.equals(cliente.getPassword()) &&
				this.numTelefono.equals(cliente.getNumTelefono() ) &&
				this.cartaDiCredito.equals(cliente.getCartaDiCredito() ) &&
				this.listaSpese.equals(cliente.getListaSpese() )   
				)
			return true;
		else
			return false;
	}



	//Getters & Setters
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getCartaDiCredito() {
		return cartaDiCredito;
	}
	public void setCartaDiCredito(String cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}
	public ArrayList<Spesa> getListaSpese() {
		return listaSpese;
	}
	public void setListaSpese(ArrayList<Spesa> listaSpese) {
		this.listaSpese = listaSpese;
	}

}
