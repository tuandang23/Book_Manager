package GCdao;

import model.Voucher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoucherDAO {
    private String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabase";
    private String jdbcUsername = "YourUsername";
    private String jdbcPassword = "YourPassword";

    private static final String SELECT_VOUCHER_BY_PHONE = "SELECT * FROM Voucher WHERE cus_phone = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Voucher> selectVoucherByPhone(String phone) {
        List<Voucher> vouchers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOUCHER_BY_PHONE);) {
            preparedStatement.setString(1, phone);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int vou_id = rs.getInt("vou_id");
                String cus_phone = rs.getString("cus_phone");
                String vou_code = rs.getString("vou_code");
                double vou_discount = rs.getDouble("vou_discount");
                String vou_status = rs.getString("vou_status");
                Date vou_expiry = rs.getDate("vou_expiry");
                vouchers.add(new Voucher(vou_id, cus_phone, vou_code, vou_discount, vou_status, vou_expiry));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }
}
