package io.github.rbuhler.nutrifactspersistency.Repositories;


import io.github.rbuhler.nutrifactspersistency.Entities.NutriFacts;
import io.github.rbuhler.nutrifactspersistency.NutrifactsPersistencyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NutrifactsPersistencyApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class NutriFactsRepositoryTest {

    @Autowired
    private NutriFactsRepository repository;

    @Test
    public void findByItem_givenAnItem_shouldReturnAListOfNutrifacts(){
        List<NutriFacts>
                nutriFactsExpected,
                nutriFactsActual;
        NutriFacts nutriFacts;

        Long item = 1L;

        nutriFacts = new NutriFacts();
        nutriFactsExpected = new ArrayList<NutriFacts>();
        nutriFactsActual = new ArrayList<NutriFacts>();

        nutriFacts.setItemId(1L);
        nutriFacts.setNutrifactId(1L);
        nutriFacts.setNutrient(10L);
        nutriFacts.setQuantity(10);
        nutriFacts.setUnitOfMeasure("gr");
        nutriFacts.setDaily_value((float) 25.5);

        repository.save(nutriFacts);
        nutriFactsExpected.add(nutriFacts);

        nutriFacts = new NutriFacts();
        nutriFacts.setItemId(1L);
        nutriFacts.setNutrifactId(2L);
        nutriFacts.setNutrient(20L);
        nutriFacts.setQuantity(20);
        nutriFacts.setUnitOfMeasure("gr");
        nutriFacts.setDaily_value((float) 45.5);

        repository.save(nutriFacts);
        nutriFactsExpected.add(nutriFacts);

        nutriFacts = new NutriFacts();
        nutriFacts.setItemId(2L);
        nutriFacts.setNutrifactId(1L);
        nutriFacts.setNutrient(15L);
        nutriFacts.setQuantity(60);
        nutriFacts.setUnitOfMeasure("km");
        nutriFacts.setDaily_value((float) 33.87);

        repository.save(nutriFacts);

        nutriFactsActual = repository.findByItemId(item);

        for (int x = 0; x < nutriFactsExpected.size(); x++ ){
            assertReflectionEquals(nutriFactsExpected.get(x), nutriFactsActual.get(x));
        }

    }
    @Test
    public void getter_setter(){
        NutriFacts
                nutriFactsExpected,
                nutriFactsActual;

        nutriFactsExpected = new NutriFacts();
        nutriFactsActual = new NutriFacts();

        nutriFactsActual.setItemId(1L);
        nutriFactsActual.setNutrifactId(1L);
        nutriFactsActual.setNutrient(10L);
        nutriFactsActual.setQuantity(10);
        nutriFactsActual.setUnitOfMeasure("gr");
        nutriFactsActual.setDaily_value((float) 25.5);

        nutriFactsExpected.setItemId(nutriFactsActual.getItemId());
        nutriFactsExpected.setNutrifactId(nutriFactsActual.getNutrifactId());
        nutriFactsExpected.setNutrient(nutriFactsActual.getNutrient());
        nutriFactsExpected.setQuantity(nutriFactsActual.getQuantity());
        nutriFactsExpected.setUnitOfMeasure(nutriFactsActual.getUnitOfMeasure());
        nutriFactsExpected.setDaily_value(nutriFactsActual.getDaily_value());
    }

}
