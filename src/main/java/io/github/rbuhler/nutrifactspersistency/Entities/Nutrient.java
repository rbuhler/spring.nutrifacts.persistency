package io.github.rbuhler.nutrifactspersistency.Entities;

import io.github.rbuhler.nutrifactspersistency.Enum.NutryCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;
    @Id
    private String nutrient;
    private NutryCategory category;
}
