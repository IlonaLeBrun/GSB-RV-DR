package fr.gsb.rv.entites;

public class RapportVisite {

	int numero ;
	String bilan ;
	
	
	public RapportVisite() {
		super();
	}
	
	public RapportVisite(int numero, String bilan) {
		super();
		this.numero = numero;
		this.bilan = bilan;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getBilan() {
		return bilan;
	}
	
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}

	@Override
	public String toString() {
		return "RapportVisite [numero=" + numero + ", bilan=" + bilan + "]";
	}
	
	
	
}
