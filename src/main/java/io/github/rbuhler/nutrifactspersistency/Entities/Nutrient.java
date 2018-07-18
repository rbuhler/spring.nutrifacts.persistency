package io.github.rbuhler.nutrifactspersistency.Entities;

import io.github.rbuhler.nutrifactspersistency.Enum.Languages;
import io.github.rbuhler.nutrifactspersistency.Enum.NutriCategory;

import javax.persistence.*;

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
    private NutriCategory category;

    public Nutrient(){}

    public Nutrient(Languages lang, String nutrient, NutriCategory category){
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

    public NutriCategory getCategory() { return category; }
    public void setCategory(NutriCategory category) { this.category = category; }
}
