package fr.gsb.rv.entites;

public class Livreur {
	
	private String nom ;
	private String prenom ;
	private int anneeInscription ;
	
	public Livreur(String nom, String prenom, int anneeInscription) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.anneeInscription = anneeInscription;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAnneeInscription() {
		return anneeInscription;
	}

	public void setAnneeInscription(int anneeInscription) {
		this.anneeInscription = anneeInscription;
	}

	@Override
	public String toString() {
		return "Livreur [nom=" + nom + ", prenom=" + prenom + ", anneeInscription=" + anneeInscription + "]";
	}

}
