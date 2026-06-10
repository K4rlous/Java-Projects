package com.productapi.controller;

// Classes que criamos!
import com.productapi.model.Product;
import com.productapi.service.ProductService;

// Injeção de dependências e anotações que iremos usar
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Uso de list e optional novamente!
import java.util.List;
import java.util.Optional;

// Indicamos pro spring que essa é a classe de controller!
@RestController
@RequestMapping("/produtos") // Indica a rota que os usuários irão acessar!
// http://localhost:8080/produtos
public class ProductController {
    @Autowired // Autoinjeção de dependências novamente!
    private ProductService productService;

    // O nome dos métodos NÃO PRECISAM ser idênticos aos métodos do service!
    // Os métodos HTTP GET, POST, PUT e DELETE são os principais verbos usados
    // em APIs REST para realizar operações de criação, leitura, atualização e exclusão (CRUD)
    // de recursos no servidor, note que as anotações indicam qual é o tipo de operação a ser realizada!

    // @RequestBody → pega dados do BODY (JSON) da requisição.
    // Usado em POST e PUT.
    // Converte JSON → Objeto Java.

    // @PathVariable → pega valor da URL.
    // Ex: /produtos/5 → id = 5
    // Usado para identificar recurso, não é à toa que recebe um ("/{id}")

    @GetMapping
    public List<Product> listarTodos(){
        return productService.listarTodos();
    }

    @PostMapping
    public Product salvar(@RequestBody Product product){
        return productService.salvar(product);
    }

    @PutMapping("/{id}")
    public Product atualizar(@PathVariable Long id, @RequestBody Product product){
        return productService.atualizar(id, product);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        productService.deletar(id);
    }

    @GetMapping("/{id}")
    public Optional<Product> findByID(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping("salvarLista")
    public List<Product> salvarLista(@RequestBody List<Product> products){
        return productService.salvarLista(products);
    }
}
