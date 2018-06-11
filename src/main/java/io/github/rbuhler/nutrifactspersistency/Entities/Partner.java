package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.*;

@Entity
public class Partner extends BaseEntity{
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column
        private Long index;

        @Column
        private String name1;
        @Column
        private String name2;
        @Column
        private String name3;

        protected Partner(){}

        public Partner(String name1, String name2, String name3){
                this.name1 = name1;
                this.name2 = name2;
                this.name3 = name3;
        }

        public Long getIndex() { return index; }
        public void setIndex(Long index) { this.index = index; }

        public String getName1() { return name1; }
        public void setName1(String name1) { this.name1 = name1; }

        public String getName2() { return name2; }
        public void setName2(String name2) { this.name2 = name2; }

        public String getName3() { return name3; }
        public void setName3(String name3) { this.name3 = name3; }
}
