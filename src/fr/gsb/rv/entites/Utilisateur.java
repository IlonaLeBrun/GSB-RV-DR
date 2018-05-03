package fr.gsb.rv.entites;

public class Utilisateur {

	private String login ;
	private String mdp ;
	
	/** Constructeur
	 * @param login Nom de connexion
	 * @param mdp Mot de passe
	 */
	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", mdp=" + mdp + "]";
	}
	
}
