package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.UnitOfMeasure;
import io.github.rbuhler.nutrifactspersistency.NutrifactsPersistencyApplication;
import io.github.rbuhler.nutrifactspersistency.localization.Languages;
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
public class UnitOfMeasureRepositoryTest {

    @Autowired
    private UnitOfMeasureRepository repository;

    @Test
    public void findByIndex_givenUOMExists_shouldReturnUOM(){

            List<UnitOfMeasure>     UOMListPayload,
                                    UOMListExpected;
            UnitOfMeasure           UOMActual;

            UOMListPayload = new ArrayList<>();
            UOMListExpected = new ArrayList<>();

            UOMListPayload.add(0, new UnitOfMeasure(Languages.PT_BR, "Kg", "Quilograma", "Peso"));
            UOMListPayload.add(1, new UnitOfMeasure(Languages.EN_US, "Kg", "Kilogram", "Weight"));
            UOMListPayload.add(2, new UnitOfMeasure(Languages.PT_BR, "Km", "Quilometro", "Distância"));
            UOMListPayload.add(3, new UnitOfMeasure(Languages.EN_US, "Km", "Kilometer", "Distance"));

            UOMListExpected.add(0, UOMListPayload.get(0));
            UOMListExpected.add(1, UOMListPayload.get(1));
            UOMListExpected.add(2, UOMListPayload.get(2));
            UOMListExpected.add(3, UOMListPayload.get(3));

        for(int count = 0; count < UOMListExpected.size(); count++ ) {
            repository.save(UOMListPayload.get(count));
        }

        for(int count = 0; count < UOMListExpected.size(); count++ ){
            Long index = new Long( count+1 );

            UOMActual = repository.findByIndex( index );
            assertReflectionEquals("Record ["+ count +"] failed.", UOMListExpected.get(count), UOMActual);
        }
    }
}
