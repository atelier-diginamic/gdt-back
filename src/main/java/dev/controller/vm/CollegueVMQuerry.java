package dev.controller.vm;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import dev.domain.Role;

public class CollegueVMQuerry {

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String motDePasse;
	@NotNull
	@NotEmpty
	private String nom;
	@NotNull
	@NotEmpty
	private String prenom;
	@NotEmpty
	private List<Role> roles = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
