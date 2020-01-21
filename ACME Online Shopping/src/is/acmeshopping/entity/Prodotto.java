package is.acmeshopping.entity;

public class Prodotto {

	private int codice;
	private String nome;
	private String descrizione;
	private float prezzo;
	private int quantitaDisp;

	public Prodotto(int codice, String nome, String descrizione, float prezzo, int quantitaDisp)
	{
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantitaDisp = quantitaDisp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantitaDisp() {
		return quantitaDisp;
	}

	public void setQuantitaDisp(int quantitaDisp) {
		this.quantitaDisp = quantitaDisp;
	}

	public int getCodice()
	{
		return codice;
	}

}
