package br.univille.dsi2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.dsi2022.entity.Dispensa;

@Repository
public interface DispensaRepository extends JpaRepository<Dispensa, Long>{
    
}
