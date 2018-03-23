package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
        private String commercial_name;
        private String business_name;
        /* address */
        /* communication */
        /* fiscal_data */

        protected Company(){}

        public Company(String commercial_name, String business_name){
                this.commercial_name = commercial_name;
                this.business_name = business_name;
        }

        public String getcommercial_name() {
                return commercial_name;
        }

        public void setcommercial_name(String commercial_name) {
                this.commercial_name = commercial_name;
        }

        public String getBusiness_name() {
                return business_name;
        }

        public void setBusiness_name(String business_name) {
                this.business_name = business_name;
        }
}
