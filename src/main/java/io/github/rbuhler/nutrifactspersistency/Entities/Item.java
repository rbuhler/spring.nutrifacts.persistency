package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String barcode;
    private String identification;
    private int quantity;
    private String unitOfMeasure;
    private String image;

    protected Item(){}

    public Item (String barcode, String identification, int quantity, String unitOfMeasure, String image ){
        this.barcode = barcode;
        this.identification = identification;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.image = image;
    }
    /* Getter_Setter */

}
