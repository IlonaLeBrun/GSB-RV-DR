package fr.gsb.rv.entites;

public class Praticien {

	private int num ;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private String cp ;
	private String ville ;
	private float coefNot ;
	private String code ;
	
	public Praticien() {
		super();
	}

	public Praticien(int num, String nom, String prenom, String adresse, String cp, String ville, float coefNot,
			String code) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.coefNot = coefNot;
		this.code = code;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public float getCoefNot() {
		return coefNot;
	}

	public void setCoefNot(float coefNot) {
		this.coefNot = coefNot;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Praticien [num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp
				+ ", ville=" + ville + ", coefNot=" + coefNot + ", code=" + code + "]";
	}
	
	
	
}
