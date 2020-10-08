package dev.controller.vm;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CovoiturageVM {

	@Future
	private Date date;

	@NotBlank
	@NotNull
	private String depart;
	@NotBlank
	@NotNull
	private String destination;
	@NotBlank
	@NotNull
	private Integer vehiculeId;
	@NotBlank
	@NotNull
	private Long chauffeurId;
	private List<Integer> passagersId;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getVehiculeId() {
		return vehiculeId;
	}

	public void setVehiculeId(Integer vehiculeId) {
		this.vehiculeId = vehiculeId;
	}

	public Long getChauffeurId() {
		return chauffeurId;
	}

	public void setChauffeurId(Long chauffeurId) {
		this.chauffeurId = chauffeurId;
	}

	public List<Integer> getPassagersId() {
		return passagersId;
	}

	public void setPassagersId(List<Integer> passagersId) {
		this.passagersId = passagersId;
	}

}
