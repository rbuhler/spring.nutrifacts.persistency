package io.github.rbuhler.nutrifactspersistency.Entities;

import io.github.rbuhler.nutrifactspersistency.localization.Languages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;
    private Languages lang;
    private String shortId;
    private String description;
    private String greatness;

    protected UnitOfMeasure() {
    }

    public UnitOfMeasure(Languages lang, String shortId, String description, String greatness) {
        this.lang = lang;
        this.shortId = shortId;
        this.description = description;
        this.greatness = greatness;
    }

    public Long getIndex() {
        return index;
    }

    public Languages getLang() {
        return lang;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public void setLang(Languages lang) {
        this.lang = lang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGreatness() {
        return greatness;
    }

    public void setGreatness(String greatness) {
        this.greatness = greatness;
    }

}