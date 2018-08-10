package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Nutrient;
import io.github.rbuhler.nutrifactspersistency.Enum.Languages;
import io.github.rbuhler.nutrifactspersistency.Enum.NutriCategory;
import io.github.rbuhler.nutrifactspersistency.NutrifactsPersistencyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NutrifactsPersistencyApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class NutrientRepositoryTest {

    @Autowired
    private NutrientRepository repository;

    @Test
    public void findByIndex_givenItemExists_shouldReturnItem(){
        Nutrient nutrientPayload = getPayload();
        repository.save(nutrientPayload);
        assertReflectionEquals(nutrientPayload, repository.findByIndex(1L));
    }

    private Nutrient getPayload(){
        Nutrient nutrient = new Nutrient(
                Languages.EN_US,
                "Calcio",
                NutriCategory.CARBOHYDRATE
        );

        Nutrient nutrientPayload = new Nutrient();
        nutrientPayload.setIndex(nutrient.getIndex());
        nutrientPayload.setLang(nutrient.getLang());
        nutrientPayload.setNutrient(nutrient.getNutrient());
        nutrientPayload.setCategory(nutrient.getCategory());

        return nutrientPayload;
    }
}