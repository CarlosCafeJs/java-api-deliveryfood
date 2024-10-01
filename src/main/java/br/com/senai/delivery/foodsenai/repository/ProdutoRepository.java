package br.com.senai.delivery.foodsenai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.delivery.foodsenai.models.ProdutosFood;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosFood, Long> {

}
