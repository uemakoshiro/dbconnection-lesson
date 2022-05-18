package src.main.java;


import java.sql.Connection;

public class ProductService {

    public Product searchId(Integer id) {
        try (Connection conn = DbUtil.getConnection()) {
            ProductDao productDao = new ProductDao(conn);
            Product product = productDao.findByProductId(id);

            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    

}
