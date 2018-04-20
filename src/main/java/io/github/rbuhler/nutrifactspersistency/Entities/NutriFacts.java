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
}