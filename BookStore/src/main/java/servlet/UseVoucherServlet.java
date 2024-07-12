package servlet;

import GCdao.VoucherDAO;
import model.Voucher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UseVoucherServlet")
public class UseVoucherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VoucherDAO voucherDAO;

    public void init() {
        voucherDAO = new VoucherDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String voucherCode = request.getParameter("voucherCode");
        double totalBookCost = Double.parseDouble(request.getParameter("totalBookCost"));
        
        List<Voucher> vouchers = voucherDAO.selectVoucherByPhone(phone);
        Voucher validVoucher = null;

        for (Voucher voucher : vouchers) {
            if (voucher.getVou_code().equals(voucherCode) && 
                voucher.getVou_status().equals("valid") && 
                voucher.getVou_expiry().after(new java.util.Date())) {
                
                validVoucher = voucher;
                break;
            }
        }

        if (validVoucher != null && validVoucher.getVou_discount() <= totalBookCost) {
            double newTotal = totalBookCost - validVoucher.getVou_discount();
            request.setAttribute("newTotal", newTotal);
            request.setAttribute("voucherApplied", validVoucher);
        } else {
            request.setAttribute("error", "Invalid voucher amount or exceeds total cost.");
        }

        request.getRequestDispatcher("CvoucherResult.jsp").forward(request, response);
    }
}
