package a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
private Connection connection;
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM products ORDER BY product_id";
	private static final String SQL_INSERT = "INSERT INTO products(product_name, price) VALUES(?,?)";
	private static final String SQL_SELECT_ID = "SELECT * FROM products WHERE product_id = ?";
	private static final String SQL_UPDATE = "UPDATE products SET product_name = ?, price = ? WHERE product_id = ?";
	private static final String SQL_DELETE = "DELETE FROM products WHERE product_name = ?";
	
	public ProductDao(Connection connection) {
	    this.connection = connection;
	}

    public List<Product> findAll() {
    	List<Product> list = new ArrayList<Product>();

        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Product u = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    
    public void register(Product pro) {

        try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
        	stmt.setString(1, pro.getProductName());
        	stmt.setInt(2, pro.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Product findByProductId(Integer id) {

        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)) {
        	stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	Product u = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
                return u;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public void update(Product pro) {

    	try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
    		stmt.setString(1, pro.getProductName());
    		stmt.setInt(2, pro.getPrice());
    		stmt.setInt(3, pro.getProductId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(String name) {
        
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
    		stmt.setString(1, name);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
