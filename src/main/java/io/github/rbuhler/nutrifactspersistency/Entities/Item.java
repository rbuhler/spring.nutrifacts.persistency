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
    private int barcode;
    private String identification;
    private int size;
    private String unitOfMeasure;

    protected Item(){}

    public Item (int barcode, String identification, int size, String unitOfMeasure ){
        this.barcode = barcode;
        this.identification = identification;
        this.size = size;
        this.unitOfMeasure = unitOfMeasure;
    }
    /* Getter_Setter */

}
