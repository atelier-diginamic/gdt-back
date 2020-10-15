package dev.dto;

public class ChauffeurDtoRep {
	private int id;
	private String matricule;
	private String permis;
	private String telephone;
	private String urlImage;
	private CollegueDtoRep info;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPermis() {
		return permis;
	}

	public void setPermis(String permis) {
		this.permis = permis;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public CollegueDtoRep getInfo() {
		return info;
	}

	public void setInfo(CollegueDtoRep info) {
		this.info = info;
	}

}
