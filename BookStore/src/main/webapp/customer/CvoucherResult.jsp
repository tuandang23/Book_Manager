<%@page import="model.Voucher"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voucher Results</title>
</head>
<body>
    <h1>Voucher Results</h1>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <c:if test="${not empty voucherApplied}">
        <p>Voucher Applied: ${voucherApplied.getVou_code()}</p>
        <p>Discount: ${voucherApplied.getVou_discount()}</p>
        <p>New Total: ${newTotal}</p>
    </c:if>
    <c:if test="${empty voucherApplied}">
        <p>No valid vouchers found or voucher exceeds total cost.</p>
    </c:if>
</body>
</html>
