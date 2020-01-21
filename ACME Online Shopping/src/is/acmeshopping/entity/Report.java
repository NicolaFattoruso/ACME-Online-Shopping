package is.acmeshopping.entity;

public class Report {

	private int numSpese;
	private Cliente cliente;
	private float spesaComplessiva;


	public Report(int numSpese, Cliente cliente, float spesaComplessiva)
	{
		this.numSpese = numSpese;
		this.cliente = cliente;
		this.spesaComplessiva =  spesaComplessiva;
	}

	public float getSpesaComplessiva()
	{
		return spesaComplessiva;
	}

	public int getNumSpese()
	{
		return this.numSpese;
	}

	public Cliente getCliente()
	{
		return this.cliente;
	}

	/**
	 * Funzione che sovrascrive la default equals per confrontare due Report
	 */
	public boolean equals(Object o) {
		Report report = (Report) o;
		if(
				this.numSpese == report.getNumSpese() && 
				this.spesaComplessiva == report.getSpesaComplessiva() && 
				this.cliente.equals(report.getCliente())
				)
			return true;
		else
			return false;
	}

	public String toString()
	{
		return "\nCliente  : " + cliente.getNomeUtente() + "\nHa speso : €"
				+ getSpesaComplessiva() + "\nfacendo  : " + getNumSpese() + " spese";
	}


}
