package io.github.rbuhler.nutrifactspersistency.Repositories;


import io.github.rbuhler.nutrifactspersistency.Entities.ItemNutriFacts;
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
public class ItemNutriFactsRepositoryTest {

    @Autowired
    private ItemNutriFactsRepository repository;

    @Test
    public void findByItem_givenAnItem_shouldReturnAListOfNutrifacts(){
        List<ItemNutriFacts>
                nutriFactsExpected,
                nutriFactsActual;
        ItemNutriFacts nutriFacts;

        Long item = 1L;

        nutriFacts = new ItemNutriFacts();
        nutriFactsExpected = new ArrayList<ItemNutriFacts>();
        nutriFactsActual = new ArrayList<ItemNutriFacts>();

        nutriFacts.setItem(1L);
        nutriFacts.setIndex(1L);
        nutriFacts.setNutrient(10L);
        nutriFacts.setQuantity(10);
        nutriFacts.setUnitOfMeasure("gr");
        nutriFacts.setDaily_value((float) 25.5);

        repository.save(nutriFacts);
        nutriFactsExpected.add(nutriFacts);

        nutriFacts = new ItemNutriFacts();
        nutriFacts.setItem(1L);
        nutriFacts.setIndex(2L);
        nutriFacts.setNutrient(20L);
        nutriFacts.setQuantity(20);
        nutriFacts.setUnitOfMeasure("gr");
        nutriFacts.setDaily_value((float) 45.5);

        repository.save(nutriFacts);
        nutriFactsExpected.add(nutriFacts);

        nutriFacts = new ItemNutriFacts();
        nutriFacts.setItem(2L);
        nutriFacts.setIndex(1L);
        nutriFacts.setNutrient(15L);
        nutriFacts.setQuantity(60);
        nutriFacts.setUnitOfMeasure("km");
        nutriFacts.setDaily_value((float) 33.87);

        repository.save(nutriFacts);

        nutriFactsActual = repository.findByItem(item);

        for (int x = 0; x < nutriFactsExpected.size(); x++ ){
            assertReflectionEquals(nutriFactsExpected.get(x), nutriFactsActual.get(x));
        }

    }
    @Test
    public void getter_setter(){
        ItemNutriFacts
                nutriFactsExpected,
                nutriFactsActual;

        nutriFactsExpected = new ItemNutriFacts();
        nutriFactsActual = new ItemNutriFacts();

        nutriFactsActual.setItem(1L);
        nutriFactsActual.setIndex(1L);
        nutriFactsActual.setNutrient(10L);
        nutriFactsActual.setQuantity(10);
        nutriFactsActual.setUnitOfMeasure("gr");
        nutriFactsActual.setDaily_value((float) 25.5);

        nutriFactsExpected.setItem(nutriFactsActual.getItem());
        nutriFactsExpected.setIndex(nutriFactsActual.getIndex());
        nutriFactsExpected.setNutrient(nutriFactsActual.getNutrient());
        nutriFactsExpected.setQuantity(nutriFactsActual.getQuantity());
        nutriFactsExpected.setUnitOfMeasure(nutriFactsActual.getUnitOfMeasure());
        nutriFactsExpected.setDaily_value(nutriFactsActual.getDaily_value());
    }

}
