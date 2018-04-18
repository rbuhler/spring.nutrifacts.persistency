package io.github.rbuhler.nutrifactspersistency.Entities;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NutriFacts {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long index;
    private Long table;
}
