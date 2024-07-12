<%@ page import="java.sql.*" %>
<%
    String phone = "0939248045"; // S? ?i?n tho?i c?n tìm

    // K?t n?i t?i SQL Server
    String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=Pro_SWP;username=sa;password=12345";
    Connection conn = null;
    CallableStatement stmt = null;
    ResultSet rs = null;

    try {
        // T?i driver JDBC cho SQL Server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(connectionURL);

        // G?i stored procedure
        String sql = "{call GetVoucherByPhone(?)}";
        stmt = conn.prepareCall(sql);
        stmt.setString(1, phone);

        rs = stmt.executeQuery();

        // Hi?n th? k?t qu?
        while (rs.next()) {
            out.println("Voucher ID: " + rs.getInt("vou_id") + "<br>");
            out.println("Phone: " + rs.getString("cus_phone") + "<br>");
            out.println("Code: " + rs.getString("vou_code") + "<br>");
            out.println("Discount: " + rs.getBigDecimal("vou_discount") + "<br>");
            out.println("Status: " + rs.getString("vou_status") + "<br>");
            out.println("Expiry: " + rs.getDate("vou_expiry") + "<br><br>");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
%>
