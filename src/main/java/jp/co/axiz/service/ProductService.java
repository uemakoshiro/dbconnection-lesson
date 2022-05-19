package jp.co.axiz.service;

import java.sql.Connection;
import java.util.List;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;
import jp.co.axiz.util.DbUtil;

public class ProductService {

    public List<Product> search(Product pd) {
        try (Connection conn = DbUtil.getConnection()) {
            ProductDao productDao = new ProductDao(conn);
            List<Product> list = productDao.find(pd);

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    

}
