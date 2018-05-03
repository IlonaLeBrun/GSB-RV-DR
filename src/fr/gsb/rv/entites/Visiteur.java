package fr.gsb.rv.entites;

public class Visiteur {

	private String matricule ;
	private String nom ;
	private String prenom ;
	private int codePostal ;
	private String ville ;
	private String rapportVisite ;
	public Visiteur() {
		super();
	}

	public Visiteur(String matricule, String nom, String prenom, int codePostal, String ville, String rapportVisite) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.codePostal = codePostal;
		this.ville = ville;
		this.rapportVisite = rapportVisite ; 
	}

	public String getMatricule() {
		return matricule;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}
	

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}
	
	public String getRapportVisite() {
		return rapportVisite;
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

	
	public String setRapportVisite() {
		return rapportVisite;
	}
	
	@Override
	public String toString() {
		return "Visiteur [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
