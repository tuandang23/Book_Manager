package model;

import java.util.Date;

public class Voucher {
    private int vou_id;
    private String cus_phone;
    private String vou_code;
    private double vou_discount;
    private String vou_status;
    private Date vou_expiry;

    // Constructors
    public Voucher() {}

    public Voucher(int vou_id, String cus_phone, String vou_code, double vou_discount, String vou_status, Date vou_expiry) {
        this.vou_id = vou_id;
        this.cus_phone = cus_phone;
        this.vou_code = vou_code;
        this.vou_discount = vou_discount;
        this.vou_status = vou_status;
        this.vou_expiry = vou_expiry;
    }

    // Getters and Setters
    public int getVou_id() { return vou_id; }
    public void setVou_id(int vou_id) { this.vou_id = vou_id; }

    public String getCus_phone() { return cus_phone; }
    public void setCus_phone(String cus_phone) { this.cus_phone = cus_phone; }

    public String getVou_code() { return vou_code; }
    public void setVou_code(String vou_code) { this.vou_code = vou_code; }

    public double getVou_discount() { return vou_discount; }
    public void setVou_discount(double vou_discount) { this.vou_discount = vou_discount; }

    public String getVou_status() { return vou_status; }
    public void setVou_status(String vou_status) { this.vou_status = vou_status; }

    public Date getVou_expiry() { return vou_expiry; }
    public void setVou_expiry(Date vou_expiry) { this.vou_expiry = vou_expiry; }
}
