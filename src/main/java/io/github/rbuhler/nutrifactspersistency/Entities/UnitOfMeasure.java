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

    public UnitOfMeasure() {
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
    public void setIndex(Long index) { this.index = index; }

    public void setLang(Languages lang) {
        this.lang = lang;
    }
    public Languages getLang() {
        return lang;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }
    public String getShortId() {
        return shortId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setGreatness(String greatness) {
        this.greatness = greatness;
    }
    public String getGreatness() {
        return greatness;
    }

}