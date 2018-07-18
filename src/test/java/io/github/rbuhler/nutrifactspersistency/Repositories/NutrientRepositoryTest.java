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
    public void findByIndex_givenItemExists_sholdReturnItem(){

        Long index = 1L;
        Nutrient
                nutrientPayload,
                nutrientExpected,
                nutrientActual;

        nutrientPayload = payload();
        nutrientExpected = nutrientPayload;

        repository.save(nutrientPayload);
        nutrientActual = repository.findByIndex(index);

        assertReflectionEquals(nutrientExpected, nutrientActual);
    }

    private Nutrient payload(){
        Nutrient nutrient,
                payload;

        nutrient = new Nutrient(
                Languages.EN_US,
                "Calcio",
                NutriCategory.CARBOHYDRATE
        );

        payload = new Nutrient();

        payload.setIndex(nutrient.getIndex());
        payload.setLang(nutrient.getLang());
        payload.setNutrient(nutrient.getNutrient());
        payload.setCategory(nutrient.getCategory());

        return payload;
    }
}
