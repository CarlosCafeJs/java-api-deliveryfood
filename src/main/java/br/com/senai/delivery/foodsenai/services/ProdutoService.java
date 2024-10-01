package br.com.senai.delivery.foodsenai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import br.com.senai.delivery.foodsenai.models.ProdutosFood;
import br.com.senai.delivery.foodsenai.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired  
    private ProdutoRepository repositoryProduto;

    public ProdutosFood save(ProdutosFood produto) {
        return repositoryProduto.save(produto);
    }

    public List<ProdutosFood> findAll() {
        return repositoryProduto.findAll();
    }

    public Optional<ProdutosFood> findById(Long id) {
        return repositoryProduto.findById(id);
    }

    public void deleteById(Long id) {
        if (repositoryProduto.existsById(id)) {
            repositoryProduto.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
    }
    

    public ProdutosFood update(Long id, ProdutosFood produto) {
        if (repositoryProduto.existsById(id)) {
            produto.setId(id);
            return repositoryProduto.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
    }
}
