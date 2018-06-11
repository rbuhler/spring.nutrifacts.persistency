package io.github.rbuhler.nutrifactspersistency.Entities;

import io.github.rbuhler.nutrifactspersistency.Enum.Languages;
import io.github.rbuhler.nutrifactspersistency.Enum.NutryCategory;

import javax.persistence.*;
import java.security.PublicKey;

@Entity
public class Nutrient extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long index;

    @Column
    private Languages lang;
    @Column
    private String nutrient;
    @Column
    private NutryCategory category;

    protected Nutrient(){}

    public Nutrient(Languages lang, String nutrient, NutryCategory category){
        this.lang = lang;
        this.nutrient = nutrient;
        this.category = category;
    }

    public Long getIndex() { return index; }
    public void setIndex(Long index) { this.index = index; }

    public Languages getLang() { return lang; }
    public void setLang(Languages lang) { this.lang = lang; }

    public String getNutrient() { return nutrient; }
    public void setNutrient(String nutrient) { this.nutrient = nutrient; }

    public NutryCategory getCategory() { return category; }
    public void setCategory(NutryCategory category) { this.category = category; }
}
