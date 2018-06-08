package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(ItemNutriFacts.ItemNutriFactsId.class)
public class ItemNutriFacts{
    @Id
    private Long itemId;
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long nutrientId;

    @Version
    private long version;
    @NotBlank
    @Column(updatable = false)
    private Timestamp createdAt;
    @Column(insertable = false)
    private Timestamp modifiedAt;

    @Column
    private Long nutrient;
    @Column
    private float quantity;
    @Column
    private String unitOfMeasure;
    @Column
    private float daily_value;

    /** TODO
     * https://stackoverflow.com/questions/12930935/illegalargumentexception-expecting-idclass-mapping */
    public static class ItemNutriFactsId implements Serializable{
        private Long itemId;
        private Long nutrientId;

        public ItemNutriFactsId(){}
        public ItemNutriFactsId(Long itemId, Long nutrientId){
            this.itemId = itemId;
            this.nutrientId = nutrientId;
        }
        @Override
        public boolean equals(Object o){
            if(o == this){
                return true;
            }
            if(!(o instanceof ItemNutriFacts)){
                return false;
            }
            ItemNutriFacts itemNutriFacts = (ItemNutriFacts)o;
            return
                    Objects.equals(itemId, itemNutriFacts.getItemId()) &&
                    Objects.equals(nutrientId,itemNutriFacts.getNutrientId());
        }
        @Override
        public int hashCode(){
            return Objects.hash(itemId, nutrientId);
        }
    }

    public ItemNutriFacts(){}

    public ItemNutriFacts(
            Long indexId,
            Long nutrientId,
            Long nutrient,
            float quantity,
            String unitOfMeasure,
            float daily_value
    ){
        this.itemId = indexId;
        this.nutrientId = nutrientId;
        this.nutrient = nutrient;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.daily_value = daily_value;
    }

    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getVersion(){ return this.version; }

    public Long getNutrientId() {
        return nutrientId;
    }
    public void setNutrientId(Long nutrientId) {
        this.nutrientId = nutrientId;
    }

    public Long getNutrient() {
        return nutrient;
    }
    public void setNutrient(Long nutrient) {
        this.nutrient = nutrient;
    }

    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public float getDaily_value() {
        return daily_value;
    }
    public void setDaily_value(float daily_value) {
        this.daily_value = daily_value;
    }

    protected static Timestamp now( ){
        return new Timestamp(new Date().getTime());
    }
    @PrePersist
    protected void onPersist(){ this.createdAt = now(); }
    public Timestamp getCreatedAt(){ return this.createdAt; }

    @PreUpdate
    protected void onUpdate(){ this.modifiedAt = now(); }
    public Timestamp getModifiedAt() { return  this.modifiedAt; }
}