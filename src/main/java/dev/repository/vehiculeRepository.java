package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.VehiculeSociete;

public interface vehiculeRepository extends JpaRepository<VehiculeSociete, Integer>{

}
