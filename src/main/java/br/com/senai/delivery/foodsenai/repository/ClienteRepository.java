package br.com.senai.delivery.foodsenai.repository;

import br.com.senai.delivery.foodsenai.models.ClientesFood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClientesFood, Long> {
    ClientesFood findByEmail(String email);
}
