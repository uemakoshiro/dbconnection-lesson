
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Insert {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

            // SQL query string
            String sql = "INSERT INTO products(product_name, price) VALUES (?, ?)";

            String name = "ボールペン";
            int price = 200;
            // create statement
            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, price);

            // execute
            stmt.executeUpdate();
            System.out.println("登録しました");
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
