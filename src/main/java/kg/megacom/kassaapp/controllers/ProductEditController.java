package kg.megacom.kassaapp.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import kg.megacom.kassaapp.models.Category;
import kg.megacom.kassaapp.models.Product;
import kg.megacom.kassaapp.models.Unit;
import kg.megacom.kassaapp.services.CategoryService;
import kg.megacom.kassaapp.services.ProductService;
import kg.megacom.kassaapp.services.UnitService;
import kg.megacom.kassaapp.services.impl.CategoryServiceImpl;
import kg.megacom.kassaapp.services.impl.ProductServiceImpl;
import kg.megacom.kassaapp.services.impl.UnitServiceImpl;

public class ProductEditController {

    private Product product;
    //private CategoryServiceImpl categoryService = CategoryServiceImpl.getINSTANCE();
   // private UnitServiceImpl unitService = UnitServiceImpl.getINSTANCE();
    private CategoryService categoryService = CategoryService.INSTANCE;
    private UnitService unitService = UnitService.INSTANCE;

    @FXML
    private ComboBox<Category> cmbCategories;

    @FXML
    private ComboBox<Unit> cmbUnits;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtBarcode;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    public void setProduct(Product product) {
        this.product = product;
        if (product.getId() != null) {
            txtName.setText(product.getName());
            txtAmount.setText(String.valueOf(product.getAmount()));
            txtPrice.setText(String.valueOf(product.getPrice()));
            txtBarcode.setText(product.getBarcode());
            txtDiscount.setText(String.valueOf(product.getDiscount()));

            cmbCategories.getSelectionModel().select(product.getCategory());
            cmbUnits.getSelectionModel().select(product.getUnit());
        }
    }

    @FXML
    void onCancelClicked(ActionEvent event) {

    }

    @FXML
    void onSaveClicked(ActionEvent event) {

        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        String barcode = txtBarcode.getText();
        double amount = Double.parseDouble(txtAmount.getText());
        int discount = Integer.parseInt(txtDiscount.getText());

        Category category = cmbCategories.getSelectionModel().getSelectedItem();
        Unit unit = cmbUnits.getSelectionModel().getSelectedItem();

            product.setName(name);
            product.setPrice(price);
            product.setBarcode(barcode);
            product.setAmount(amount);
            product.setDiscount(discount);
            product.setCategory(category);
            product.setUnit(unit);

            ProductService.INSTANCE.save(product);
    }

    @FXML
    void initialize() {

        cmbCategories.setItems(FXCollections.observableList(categoryService.getCategories()));
        cmbUnits.setItems(FXCollections.observableList(unitService.getUnits()));

    }

}
