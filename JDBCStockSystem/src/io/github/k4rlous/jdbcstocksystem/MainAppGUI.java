package io.github.k4rlous.jdbcstocksystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public class MainAppGUI  extends Application {
    private ProductDAO productDAO;
    private ObservableList<Product> products;
    private TableView<Product> tableView;
    private TextField nameInput, quantityInput, priceInput;
    private ComboBox<String> statusComboBox;
    private Connection connectionDB;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("/icons/icon.png"));

        connectionDB = ConnectionDB.conectar();
        productDAO = new ProductDAO(connectionDB); // Inicializa o DAO
        products = FXCollections.observableArrayList(productDAO.listarTodos()); // Carrega todos os produtos do banco de dados

        stage.setTitle("Product inventory management");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(10);

        HBox nameProductBox = new  HBox();
        nameProductBox.setSpacing(10);
        Label nameLabel = new Label("Product:");
        nameInput = new TextField();
        nameProductBox.getChildren().addAll(nameLabel, nameInput);

        HBox quantityBox = new  HBox();
        quantityBox.setSpacing(10);
        Label quantityLabel = new Label("Quantity:");
        quantityInput = new TextField();
        quantityBox.getChildren().addAll(quantityLabel, quantityInput);

        HBox priceBox = new  HBox();
        priceBox.setSpacing(10);
        Label priceLabel = new Label("Price:");
        priceInput = new TextField();
        priceBox.getChildren().addAll(priceLabel, priceInput);

        HBox statusBox = new  HBox();
        statusBox.setSpacing(10);
        Label statusLabel = new Label("Status:");
        statusComboBox = new ComboBox<>(); // Uso de generics porque ComboBox pode ser usado com String, Integers e etc
        statusComboBox.getItems().addAll("Normal Stock", "Low Stock");
        statusBox.getChildren().addAll(statusLabel, statusComboBox);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String price  = priceInput.getText().replace(",", "."); // Para podermos usar tanto ',' quanto '.'
            Product product = new Product(nameInput.getText(),
                    Integer.parseInt(quantityInput.getText()), // Conversão para integer do campo 'quantidade'
                    Double.parseDouble(price), // Já usamos o 'priceInput.getText()' acima!
                    statusComboBox.getValue());
            productDAO.inserir(product); // Insere novo produto na base de dados
            products.setAll(productDAO.listarTodos()); // Atualiza a lista de produtos na tela
            clearInputs(); // Limpa os inputs para uma nova operação
        });

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
           Product selectedProduct = tableView.getSelectionModel().getSelectedItem(); // Obtém o produto selecionado
            if(selectedProduct != null){
                selectedProduct.setNome(nameInput.getText());
                selectedProduct.setQuantidade(Integer.parseInt(quantityInput.getText()));
                String price  = priceInput.getText().replace(",", ".");
                selectedProduct.setPreco(Double.parseDouble(price));
                selectedProduct.setStatus(statusComboBox.getValue());
                productDAO.atualizar(selectedProduct); // Atualiza o produto no banco de dados
                products.setAll(productDAO.listarTodos()); // Atualiza a lista de produtos
                clearInputs();
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Product selectedProduct = tableView.getSelectionModel().getSelectedItem();
            if(selectedProduct != null){
                productDAO.excluir(selectedProduct.getId()); // Exclui o produto do banco de dados pelo ID
                products.setAll(productDAO.listarTodos()); // Novamente atualiza a lista de produtos
                clearInputs();
            }
        });

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> clearInputs());

        tableView = new  TableView<>();
        tableView.setItems(products); // Define a lista de produtos na tabela
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS); // Ajusta o tamanho das
        // colunas
        List<TableColumn<Product, ?>> columns = List.of(
                createColumn("ID", "id"),
                createColumn("Product", "nome"),
                createColumn("Quantity", "quantidade"),
                createColumn("Price", "preco"),
                createColumn("Status", "status")
        );
        // Cria uma lista de colunas para a tabela 'tableView'
        tableView.getColumns().addAll(columns);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            // Esse bloco adiciona um 'listener' sempre que algo mudar dentro de 'tableView' ocorrerá o que está
            // dentro da Lambda!
            if (newSelection !=  null) {
                nameInput.setText(newSelection.getNome());
                quantityInput.setText(String.valueOf(newSelection.getQuantidade()));
                priceInput.setText(String.valueOf(newSelection.getPreco()));
                statusComboBox.setValue(newSelection.getStatus());
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(addButton, updateButton, deleteButton, clearButton); // Agrupa os botões

        vBox.getChildren().addAll(nameProductBox, quantityBox, priceBox, statusBox, buttonBox, tableView); // Ordena
        // os 'box' criados em um padrão vertical

        Scene  scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        scene.getStylesheets().add(getClass().getResource("/styles/styles-products.css").toExternalForm());
        stage.show();
    }

    /*
      O método 'stop' é automaticamente chamado quando a aplicação JavaFX é encerrada, então não há a necessidade de
           incluir ele no código!
     */

    @Override
    public void stop() {
       try {
           connectionDB.close(); // Fecha a conexão com o banco de dados
       } catch (SQLException e) {
           System.err.println("Error closing connection" + e.getMessage());
       }
    }

    private void clearInputs(){
        nameInput.clear();
        quantityInput.clear();
        priceInput.clear();
        statusComboBox.setValue(null);
    }

    /**
     * Cria uma coluna para a TableView
     * @param title O titulo da coluna que será exibido no cabeçalho.
     * @param property A propriedade do objeto Product que esta coluna deve exibir.
     * @return A coluna configurada para o TableView
     */
    private TableColumn<Product, String> createColumn(String title, String property) {
        TableColumn<Product, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property)); // Define a propriedade da coluna
        return col;
    }
}
