package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class NutriFacts {
    @Id
    private Long item_index;
    @Id
    private Nutrient nutrient;
    private float quantity;
    private UnitOfMeasure unit_of_measure;
    private float daily_value;

    public NutriFacts(){};

    public NutriFacts(Long item_index,
                      Nutrient nutrient,
                      float quantity,
                      UnitOfMeasure unit_of_measure,
                      float daily_value  ){};


    public Long getItem_index() {
        return item_index;
    }

    public void setItem_index(Long item_index) {
        this.item_index = item_index;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public UnitOfMeasure getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(UnitOfMeasure unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public float getDaily_value() {
        return daily_value;
    }

    public void setDaily_value(float daily_value) {
        this.daily_value = daily_value;
    }
}