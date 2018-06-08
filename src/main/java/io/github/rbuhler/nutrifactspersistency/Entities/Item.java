package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long indexId;

    @Version
    private long version;
    @NotBlank
    @Column(updatable = false)
    private Timestamp createdAt;
    @Column(insertable = false)
    private Timestamp modifiedAt;

    @Column
    private String barcode;
    @Column
    private String identification;
    @Column
    private int quantity;
    @Column
    private String unitOfMeasure;
    @Column
    private String image;
    @Column
    private float servSize;
    @Column
    private String servUom;
    @Column
    private float servCalories;
    @Column
    private String disclaimer;

    public Item(){}

    public Item (
            String barcode,
            String identification,
            int quantity,
            String unitOfMeasure,
            String image,
            float servSize,
            String servUom,
            float servCalories,
            String disclaimer
    ){
        this.barcode = barcode;
        this.identification = identification;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.image = image;
        this.servSize = servSize;
        this.servUom = servUom;
        this.servCalories = servCalories;
        this.disclaimer = disclaimer;
    }

    public Long getIndexId() {
        return indexId;
    }
    public void setIndexId(Long indexId) { this.indexId = indexId; }

    public Long getVersion() { return this.version; }

    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public float getServSize() { return servSize; }
    public void setServSize(float servSize) { this.servSize = servSize; }

    public String getServUom() { return servUom; }
    public void setServUom(String servUom) { this.servUom = servUom; }

    public float getServCalories() { return servCalories; }
    public void setServCalories(float servCalories) { this.servCalories = servCalories; }

    public String getDisclaimer() { return disclaimer; }
    public void setDisclaimer(String disclaimer) { this.disclaimer = disclaimer; }

    protected static Timestamp now( ){
        return new Timestamp(new Date().getTime());
    }
    @PrePersist
    protected void onPersist(){
        this.createdAt = now();
    }
    public Timestamp getCreatedAt(){ return this.createdAt; }

    @PreUpdate
    protected void onUpdate(){
        this.modifiedAt = now();
    }
    public Timestamp getModifiedAt() { return  this.modifiedAt; }
}