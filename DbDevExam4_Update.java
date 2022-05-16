
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Update {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

            // SQL query string
            String sql = "UPDATE products SET price = ? WHERE product_id = ?";

            int price = 60;
            int id = 101;
            // create statement
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, price);
            stmt.setInt(2, id);

            // execute
            stmt.executeUpdate();
            System.out.println("更新しました");
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
