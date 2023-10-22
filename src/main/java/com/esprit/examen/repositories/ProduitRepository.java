package com.esprit.examen.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.esprit.examen.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {


}
