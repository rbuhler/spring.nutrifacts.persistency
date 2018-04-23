package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ItemNutriFacts implements Serializable {
    @Id
    private Long item;
    @Id
    private Long index;
    private Long nutrient;
    private float quantity;
    private String unitOfMeasure;
    private float daily_value;

    public ItemNutriFacts(){}

    public ItemNutriFacts(Long item,
                          Long index,
                          Long nutrient,
                          float quantity,
                          String unitOfMeasure,
                          float daily_value  ){}


    public Long getItem() {
        return item;
    }
    public void setItem(Long item) {
        this.item = item;
    }

    public Long getIndex() {
        return index;
    }
    public void setIndex(Long index) {
        this.index = index;
    }

    public Long getNutrient() {
        return nutrient;
    }
    public void setNutrient(Long nutrient) {
        this.nutrient = nutrient;
    }

    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public float getDaily_value() {
        return daily_value;
    }
    public void setDaily_value(float daily_value) {
        this.daily_value = daily_value;
    }

}