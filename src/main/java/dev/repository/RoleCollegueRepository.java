package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entity.Collegue;
import dev.entity.RoleCollegue;
import enumeration.Role;

public interface RoleCollegueRepository extends JpaRepository<RoleCollegue, Integer> {

	
	@Query("select distinct rc.collegue from RoleCollegue rc where rc.role=?1")
	List<Collegue> getByRole(Role role);

}
