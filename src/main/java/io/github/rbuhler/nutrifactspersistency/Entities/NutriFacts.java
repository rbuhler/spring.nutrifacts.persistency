package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(NutriFacts.NutriFactsId.class)
public class NutriFacts extends BaseEntity {
    @Id
    private Long itemId;
    @Id
    private Long nutrientId;

    @Column
    private float quantity;
    @Column
    private String unitOfMeasure;
    @Column
    private float daily_value;

//    /** TODO
//     * https://stackoverflow.com/questions/12930935/illegalargumentexception-expecting-idclass-mapping */
    public static class NutriFactsId implements Serializable{
        private Long itemId;
        private Long nutrientId;

        public NutriFactsId(){}
        public NutriFactsId(Long itemId, Long nutrientId){
            this.itemId = itemId;
            this.nutrientId = nutrientId;
        }
        @Override
        public boolean equals(Object o){
            if(o == this){
                return true;
            }
            if(!(o instanceof NutriFacts)){
                return false;
            }
            NutriFacts nutriFacts = (NutriFacts)o;
            return
                    Objects.equals(itemId, nutriFacts.getItemId()) &&
                    Objects.equals(nutrientId, nutriFacts.getNutrientId());
        }
        @Override
        public int hashCode(){
            return Objects.hash(itemId, nutrientId);
        }
    }

    public NutriFacts(){}

    public NutriFacts(
            Long itemId,
            Long nutrientId,
            float quantity,
            String unitOfMeasure,
            float daily_value
    ){
        this.itemId = itemId;
        this.nutrientId = nutrientId;
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

    public Long getNutrientId() {
        return nutrientId;
    }
    public void setNutrientId(Long nutrient) {
        this.nutrientId = nutrient;
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
}