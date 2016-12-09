/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Danni
 */
public class ModelSales {
    private String idCustomer;
    private String idProduct;
    private String idSold;
    private String name;
    private float total;
    private double totalN;
    private double price;
    private double totalP;
    private int number;
    private float iva = (float) 0.16;

    /**
     * @return the idCustomer
     */
    public String getIdCustomer() {
        return idCustomer;
    }

    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * @return the idProduct
     */
    public String getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the totalN
     */
    public double getTotalN() {
        return totalN;
    }

    /**
     * @param totalN the totalN to set
     */
    public void setTotalN(double totalN) {
        this.totalN = totalN;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the totalP
     */
    public double getTotalP() {
        return totalP;
    }

    /**
     * @param totalP the totalP to set
     */
    public void setTotalP(double totalP) {
        this.totalP = totalP;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the iva
     */
    public float getIva() {
        return iva;
    }

    /**
     * @return the idSold
     */
    public String getIdSold() {
        return idSold;
    }

    /**
     * @param idSold the idSold to set
     */
    public void setIdSold(String idSold) {
        this.idSold = idSold;
    }

}
