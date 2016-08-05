package com.rubik.appproductsvolley2.model;

import java.sql.Timestamp;

/**
 * Created by Rubik on 2/8/16.
 */
public class Product {
    private String tittle;
    private String imageURL;
    private int units;
    private double pvp;
    private String description;
    private Double rating;
    private Timestamp fecha;

    public Product(String imageURL, String tittle, Timestamp fecha) {
        this.imageURL = imageURL;
        this.tittle = tittle;
        this.fecha = fecha;
    }

    public Product(String tittle, String imageURL, int units, double pvp, String description, Double rating) {
        this.tittle = tittle;
        this.imageURL = imageURL;
        this.units = units;
        this.pvp = pvp;
        this.description = description;
        this.rating = rating;
    }

    public Product(String tittle, String imageURL, int units, double pvp, Double rating, Timestamp fecha) {
        this.tittle = tittle;
        this.imageURL = imageURL;
        this.units = units;
        this.pvp = pvp;
      //  this.description = description;
        this.rating = rating;
        this.fecha = fecha;
    }


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Timestamp getFecha() {return fecha;}

    public void setFecha(Timestamp fecha) {this.fecha = fecha;}


}
