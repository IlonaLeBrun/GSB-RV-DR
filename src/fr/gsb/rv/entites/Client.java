package fr.gsb.rv.entites;

public class Client {
	
	private String nom ;
	private String codePostal ;
	
	public Client(String nom, String codePostal) {
		super();
		this.nom = nom;
		this.codePostal = codePostal;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", codePostal=" + codePostal + "]";
	}
}
