package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class NutriTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;
    private Item item;

    private float serv_size;
    private UnitOfMeasure serv_uom;
    private float serv_calories;

    private String disclaimer;

    private List<NutriFacts> nutriFacts;
}