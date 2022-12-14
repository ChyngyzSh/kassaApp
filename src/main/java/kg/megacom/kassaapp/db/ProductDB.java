package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.ProductDBImpl;
import kg.megacom.kassaapp.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDB {
    ProductDB INSTANCE = new ProductDBImpl();

    void insert(Product product);

    List<Product> selectProduct();

    void update(Product product);

    Product findProductByBarcode(String barcode);


    void delete(Integer id) throws SQLException;
}
