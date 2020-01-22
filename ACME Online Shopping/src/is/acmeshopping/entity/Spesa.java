package is.acmeshopping.entity;

import java.util.ArrayList;
import java.util.Date;

public class Spesa {

	private int ID;
	private Date data;
	private float costo = 0;
	private StatoOrdine statoOrdine;
	private ArrayList<QuantitaProdotti> quantitaProdotti;

	public Spesa(int ID, Date data, ArrayList<QuantitaProdotti> quantitaProdotto)
	{
		this.ID = ID;
		this.data = data;
		this.statoOrdine = StatoOrdine.ORDINATA;
		this.quantitaProdotti = new ArrayList<QuantitaProdotti>(quantitaProdotto);
		for( QuantitaProdotti p : quantitaProdotti)
		{
			this.costo += ( p.getProdotto().getPrezzo() ) * p.getQuantita();
		}

	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public StatoOrdine getStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(StatoOrdine statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public int getID() {
		return ID;
	}

	public ArrayList<QuantitaProdotti> getQuantitaProdotto() {
		return quantitaProdotti;
	}

}



