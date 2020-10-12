package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Integer>{

}
