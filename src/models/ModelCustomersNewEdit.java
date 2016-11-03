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
public class ModelCustomersNewEdit {
    
    private String name;
    private String ap_pat;
    private String ap_ma;
    private String state;
    private String Street;
    private String city;
    private String suburb;
    private int no;
    private String nick;
    private String number;
    private String email;
    private String data;
    private Object editableValues;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   
    public String getAp_pat() {
        return ap_pat;
    }
    
    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_ma() {
        return ap_ma;
    }

    public void setAp_ma(String ap_ma) {
        this.ap_ma = ap_ma;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }

 
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the Street
     */
    public String getStreet() {
        return Street;
    }

    /**
     * @param Street the Street to set
     */
    public void setStreet(String Street) {
        this.Street = Street;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @param editableValues the editableValues to set
     */
    public void setEditableValues(Object editableValues) {
        this.editableValues = editableValues;
    }

    /**
     * @return the editableValues
     */
    public Object getEditableValues() {
        return editableValues;
    }

}
