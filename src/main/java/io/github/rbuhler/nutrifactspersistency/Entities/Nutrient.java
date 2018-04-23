package io.github.rbuhler.nutrifactspersistency.Entities;

import io.github.rbuhler.nutrifactspersistency.Enum.Languages;
import io.github.rbuhler.nutrifactspersistency.Enum.NutryCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;
    private Languages lang;
    private String nutrient;
    private NutryCategory category;
}
