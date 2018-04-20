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

    private float serv_size;
    private UnitOfMeasure serv_uom;
    private float serv_calories;
    private String disclaimer;

    public Item(){}

    public Item (String barcode,
                 String identification,
                 int quantity,
                 String unitOfMeasure,
                 String image,
                 float serv_size,
                 UnitOfMeasure serv_uom,
                 float serv_calories,
                 String disclaimer
    ){
        this.barcode = barcode;
        this.identification = identification;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.image = image;
        this.serv_size = serv_size;
        this.serv_uom = serv_uom;
        this.serv_calories = serv_calories;
        this.disclaimer = disclaimer;
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

    public float getServ_size() { return serv_size; }
    public void setServ_size(float serv_size) { this.serv_size = serv_size; }

    public UnitOfMeasure getServ_uom() { return serv_uom; }
    public void setServ_uom(UnitOfMeasure serv_uom) { this.serv_uom = serv_uom; }

    public float getServ_calories() { return serv_calories; }
    public void setServ_calories(float serv_calories) { this.serv_calories = serv_calories; }

    public String getDisclaimer() { return disclaimer; }
    public void setDisclaimer(String disclaimer) { this.disclaimer = disclaimer; }
}