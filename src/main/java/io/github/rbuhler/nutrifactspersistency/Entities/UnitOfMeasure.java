package io.github.rbuhler.nutrifactspersistency.Entities;

import io.github.rbuhler.nutrifactspersistency.Enum.Greatness;
import io.github.rbuhler.nutrifactspersistency.Enum.Languages;
import javax.persistence.*;

@Entity
public class UnitOfMeasure extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long index;

    @Column
    private Languages lang;
    @Column
    private String shortId;
    @Column
    private String description;
    @Column
    private Greatness greatness;

    public UnitOfMeasure() { }
    public UnitOfMeasure(
            Languages lang,
            String shortId,
            String description,
            Greatness greatness
    ){
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

    public void setGreatness(Greatness greatness) {
        this.greatness = greatness;
    }
    public Greatness getGreatness() {
        return greatness;
    }
}