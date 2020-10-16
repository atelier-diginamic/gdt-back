package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer>{

	


}
