package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.*;

@Entity
//@IdClass(NutriFacts.ItemNutriFactsId.class)
public class NutriFacts extends BaseEntity{
    @Id
    @Column
    private Long itemId;
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long nutrifactId;

    @Column
    private Long nutrient;
    @Column
    private float quantity;
    @Column
    private String unitOfMeasure;
    @Column
    private float daily_value;

//    /** TODO
//     * https://stackoverflow.com/questions/12930935/illegalargumentexception-expecting-idclass-mapping */
//    public static class ItemNutriFactsId implements Serializable{
//        private Long itemId;
//        private Long nutrientId;
//
//        public ItemNutriFactsId(){}
//        public ItemNutriFactsId(Long itemId, Long nutrifactId){
//            this.itemId = itemId;
//            this.nutrientId = nutrifactId;
//        }
//        @Override
//        public boolean equals(Object o){
//            if(o == this){
//                return true;
//            }
//            if(!(o instanceof NutriFacts)){
//                return false;
//            }
//            NutriFacts nutriFacts = (NutriFacts)o;
//            return
//                    Objects.equals(itemId, nutriFacts.getItemId()) &&
//                    Objects.equals(nutrientId, nutriFacts.getNutrifactId());
//        }
//        @Override
//        public int hashCode(){
//            return Objects.hash(itemId, nutrientId);
//        }
//    }

    public NutriFacts(){}

    public NutriFacts(
            Long itemId,
            Long nutrifactId,
            Long nutrient,
            float quantity,
            String unitOfMeasure,
            float daily_value
    ){
        this.itemId = itemId;
        this.nutrifactId = nutrifactId;
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

    public Long getNutrifactId() {
        return nutrifactId;
    }
    public void setNutrifactId(Long nutrifactId) {
        this.nutrifactId = nutrifactId;
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
}