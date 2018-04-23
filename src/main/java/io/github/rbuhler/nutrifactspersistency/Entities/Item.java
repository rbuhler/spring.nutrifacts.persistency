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

    private float servSize;
    private String servUom;
    private float servCalories;
    private String disclaimer;

    public Item(){}

    public Item (
            String barcode,
            String identification,
            int quantity,
            String unitOfMeasure,
            String image,
            float servSize,
            String servUom,
            float servCalories,
            String disclaimer
    ){
        this.barcode = barcode;
        this.identification = identification;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.image = image;
        this.servSize = servSize;
        this.servUom = servUom;
        this.servCalories = servCalories;
        this.disclaimer = disclaimer;
    }

    public Long getIndex() {
        return index;
    }
    public void setIndex(Long index) { this.index = index; }

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

    public float getServSize() { return servSize; }
    public void setServSize(float servSize) { this.servSize = servSize; }

    public String getServUom() { return servUom; }
    public void setServUom(String servUom) { this.servUom = servUom; }

    public float getServCalories() { return servCalories; }
    public void setServCalories(float servCalories) { this.servCalories = servCalories; }

    public String getDisclaimer() { return disclaimer; }
    public void setDisclaimer(String disclaimer) { this.disclaimer = disclaimer; }
}