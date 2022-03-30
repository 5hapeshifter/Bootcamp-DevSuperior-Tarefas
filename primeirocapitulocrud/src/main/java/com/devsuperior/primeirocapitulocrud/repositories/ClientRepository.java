package com.devsuperior.primeirocapitulocrud.repositories;

import com.devsuperior.primeirocapitulocrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
