/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.ResultSet;
import java.util.GregorianCalendar;
import java.util.Calendar;
import javax.swing.JOptionPane;
import jdda.ConnectionDB;
/**
 *
 * @author Raúl
 */
public class ModelShopping {
    private ConnectionDB cb = new ConnectionDB();
    Calendar gCalendar = new GregorianCalendar();
    private String date = ""+gCalendar.get(Calendar.DAY_OF_MONTH)+"/"+gCalendar.get(Calendar.MONTH)+"/"+gCalendar.get(Calendar.YEAR);
    private String id_supplier;
    private double price_product;
    private String id_product;
    private String name_product;
    private String name_supplier;
    private int quantity;
    private double iva = .16;
    private double subtotal = 0;
    private double total;
    private double totalProduct = 0;
    private int id_shop;
    
    public void clean(){
        subtotal = 0;
        total = 0;
        this.id_shop = 0;
    }
    
    public void supplier(){
        try {
            cb.Connection("acme_shop", "root", "1234");
            ResultSet rs;
            rs = cb.query("Select nombre from proveedores where id_proveedor = "+id_supplier);
            rs.next();
            name_supplier = rs.getString("nombre");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El id que inserto es incorrecto por favor verificalo");
            System.err.println(e.getMessage()+"\nsupplier() en modelShopping");
        }
    }
    
    public void product(){
        try {
            cb.Connection("acme_shop", "root", "1234");
            ResultSet rs;
            rs = cb.query("Select producto, precio_compra from productos where id_producto = "+id_product);
            rs.next();
            name_product = rs.getString("producto");
            setPrice_product(rs.getDouble("precio_compra"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El id que inserto es incorrecto por favor verificalo");
            System.err.println(e.getMessage()+"\nsupplier() en modelShopping");
        }
    }
    
    public void showSubTotal(){
        setTotalProduct(quantity * getPrice_product());
        subtotal = subtotal + getTotalProduct();
        total = subtotal+(subtotal * iva);
    }
    
    public void deleteProduct(){
        total = subtotal + (subtotal*iva);
    }
    
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the id_supplier
     */
    public String getId_supplier() {
        return id_supplier;
    }

    /**
     * @param id_supplier the id_supplier to set
     */
    public void setId_supplier(String id_supplier) {
        this.id_supplier = id_supplier;
    }

    /**
     * @return the id_product
     */
    public String getId_product() {
        return id_product;
    }

    /**
     * @param id_product the id_product to set
     */
    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    /**
     * @return the name_product
     */
    public String getName_product() {
        return name_product;
    }

    /**
     * @param name_product the name_product to set
     */
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    /**
     * @return the name_supplier
     */
    public String getName_supplier() {
        return name_supplier;
    }

    /**
     * @param name_supplier the name_supplier to set
     */
    public void setName_supplier(String name_supplier) {
        this.name_supplier = name_supplier;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the price_product
     */
    public double getPrice_product() {
        return price_product;
    }

    /**
     * @param price_product the price_product to set
     */
    public void setPrice_product(double price_product) {
        this.price_product = price_product;
    }

    /**
     * @return the totalProduct
     */
    public double getTotalProduct() {
        return totalProduct;
    }

    /**
     * @param totalProduct the totalProduct to set
     */
    public void setTotalProduct(double totalProduct) {
        this.totalProduct = totalProduct;
    }

    /**
     * @return the id_shop
     */
    public int getId_shop() {
        return id_shop;
    }

    /**
     * @param id_shop the id_shop to set
     */
    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }
    
}
