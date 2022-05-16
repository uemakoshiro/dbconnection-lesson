import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbExam4 {
	
	public static void main(String args[]) {
		
		Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

            // SQL query string
            String sql = "SELECT * FROM products WHERE product_id = ? OR product_name = ? ORDER BY product_id";

            // create statement
            int id = 101;
            String name = "地球儀";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, name);

            // execute
            ResultSet rs = stmt.executeQuery();

            // output
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                int price = rs.getInt("price");

                System.out.print("product_id:"+product_id);
                System.out.print(","+"product_name:"+product_name);
                System.out.println(","+"price:"+price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
