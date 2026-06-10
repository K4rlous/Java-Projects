package com.productapi.service;

// Importação das classes que criamos anteriormente!
import com.productapi.model.Product;
import com.productapi.repository.ProductRepository;

// Injeção automática de dependências do Springboot!
import org.springframework.beans.factory.annotation.Autowired;

// Serve para marcar a classe como a lógica de negócios pro Spring!
import org.springframework.stereotype.Service;

// Coleção
import java.util.List;

// Classe de container genérico, pode conter um valor não nulo ou estar vazia
// usada para evitar null e prevenir NullPointerException!
import java.util.Optional;

// Marcação da classe!
@Service
public class ProductService {
    @Autowired //Injeção do Autowired!
    private ProductRepository productRepository;

    // Retorna a lista de produtos da base de dados
    public List<Product> listarTodos(){
        return productRepository.findAll();
    }

    // Salva o produto
    public Product salvar(Product product){
        return productRepository.save(product);
    }

    // Deleta o produto com base no seu ID
    public void deletar(Long id){
        productRepository.deleteById(id);
    }

    // Recebe o ID e um produto, atualiza a base de dados
    public Product atualizar(Long id, Product product){
        if(productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> salvarLista(List<Product> products){
        return productRepository.saveAll(products);
    }
}
