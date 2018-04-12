package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long index;
    private String barcode;
    private String identification;
    private int quantity;
    private String unitOfMeasure;
    private String image;

    public Item(){}

    public Item (String barcode, String identification, int quantity, String unitOfMeasure, String image ){
        this.barcode = barcode;
        this.identification = identification;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.image = image;
    }

    public Long getIndex() {
        return index;
    }
    public void setIndex(Long index) {
        this.index = index;
    }

    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
