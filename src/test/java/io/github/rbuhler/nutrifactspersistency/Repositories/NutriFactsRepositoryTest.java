package io.github.rbuhler.nutrifactspersistency.Repositories;


import io.github.rbuhler.nutrifactspersistency.Entities.NutriFacts;
import io.github.rbuhler.nutrifactspersistency.NutrifactsPersistencyApplication;
import org.junit.Assert;
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
    public void findByItem_givenAnItem_shouldReturnANutrifact(){
        List<NutriFacts> nutriFactsPayloadList = getPayloadList();
        repository.save(nutriFactsPayloadList.get(0));
        repository.save(nutriFactsPayloadList.get(1));
        repository.save(nutriFactsPayloadList.get(2));

        for (Integer x = 0; x < nutriFactsPayloadList.size(); x++ ){
            List<NutriFacts> nutriFactsActual = repository.findByItemId( x.longValue()+1L );
            assertReflectionEquals(nutriFactsPayloadList.get(x), nutriFactsActual.get(0));
        }
    }

    @Test
    public void findByItem_givenAnItem_shouldReturnAListOfNutrifacts(){
        List<NutriFacts> nutriFactsPayloadList = getPayloadList();
        repository.save(nutriFactsPayloadList.get(0));
        repository.save(nutriFactsPayloadList.get(1));
        repository.save(nutriFactsPayloadList.get(2));

        List<NutriFacts> nutriFactsActual = repository.findByItemId( 1L );

        for (Integer x = 0; x < nutriFactsActual.size(); x++ ){
            Assert.assertEquals( 2, nutriFactsActual.size() );
        }
    }

    public NutriFacts getPayload(){
        NutriFacts nutrifacts = new NutriFacts(
                1L,
                1L,
                10L,
                10,
                "gr",
                (float)25.5 );

        NutriFacts nutrifactsPayload = new NutriFacts();
        nutrifactsPayload.setItemId(nutrifacts.getItemId());
        nutrifactsPayload.setNutrifactId(nutrifacts.getNutrifactId());
        nutrifactsPayload.setNutrient(nutrifacts.getNutrient());
        nutrifactsPayload.setQuantity(nutrifacts.getQuantity());
        nutrifactsPayload.setUnitOfMeasure(nutrifacts.getUnitOfMeasure());
        nutrifactsPayload.setDaily_value(nutrifacts.getDaily_value());

        return nutrifactsPayload;
    }

    public List<NutriFacts> getPayloadList(){

        NutriFacts nutriFacts = new NutriFacts();
        List nutriFactsPayloadList = new ArrayList<NutriFacts>();

        nutriFacts.setItemId(1L);
        nutriFacts.setNutrifactId(1L);
        nutriFacts.setNutrient(10L);
        nutriFacts.setQuantity(10);
        nutriFacts.setUnitOfMeasure("gr");
        nutriFacts.setDaily_value((float) 25.5);
        nutriFactsPayloadList.add(nutriFacts);

        nutriFacts = new NutriFacts();
        nutriFacts.setItemId(2L);
        nutriFacts.setNutrifactId(3L);
        nutriFacts.setNutrient(20L);
        nutriFacts.setQuantity(20);
        nutriFacts.setUnitOfMeasure("gr");
        nutriFacts.setDaily_value((float) 45.5);
        nutriFactsPayloadList.add(nutriFacts);

        nutriFacts = new NutriFacts();
        nutriFacts.setItemId(1L);
        nutriFacts.setNutrifactId(2L);
        nutriFacts.setNutrient(15L);
        nutriFacts.setQuantity(60);
        nutriFacts.setUnitOfMeasure("km");
        nutriFacts.setDaily_value((float) 33.87);
        nutriFactsPayloadList.add(nutriFacts);

        return  nutriFactsPayloadList;
    }
}
