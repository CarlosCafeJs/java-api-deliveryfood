package br.com.senai.delivery.foodsenai.controllers.products;

import br.com.senai.delivery.foodsenai.models.ProdutosFood;
import br.com.senai.delivery.foodsenai.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class AtualizarProduto {

    @Autowired
    private ProdutoService produtoService;

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosFood> update(@PathVariable Long id, @RequestBody ProdutosFood produto) {
        ProdutosFood updatedProduct = produtoService.update(id, produto);
        
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
