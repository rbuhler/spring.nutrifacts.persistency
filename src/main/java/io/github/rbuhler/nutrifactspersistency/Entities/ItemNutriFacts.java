package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ItemNutriFacts.ItemNutriFactsId.class)
public class ItemNutriFacts{
    @Id
    @OneToMany
    private Long item;
    @Id
    @ManyToOne
    private Long index;
    private Long nutrient;
    private float quantity;
    private String unitOfMeasure;
    private float daily_value;

    /** TODO
     * https://stackoverflow.com/questions/12930935/illegalargumentexception-expecting-idclass-mapping */
    public static class ItemNutriFactsId implements Serializable{
        private Long item;
        private Long index;

        public ItemNutriFactsId(){}
        public ItemNutriFactsId(Long item, Long index){
            this.item = item;
            this.index = index;
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
                    Objects.equals(item, itemNutriFacts.getItem()) &&
                    Objects.equals(index,itemNutriFacts.getIndex());
        }
        @Override
        public int hashCode(){
            return Objects.hash(item, index);
        }
    }

    public ItemNutriFacts(){}

    public ItemNutriFacts(
            Long item,
            Long index,
            Long nutrient,
            float quantity,
            String unitOfMeasure,
            float daily_value
    ){
        this.item = item;
        this.index = index;
        this.nutrient = nutrient;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.daily_value = daily_value;
    }

    public Long getItem() {
        return item;
    }
    public void setItem(Long item) {
        this.item = item;
    }

    public Long getIndex() {
        return index;
    }
    public void setIndex(Long index) {
        this.index = index;
    }

    public Long getNutrient(long l) {
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
}