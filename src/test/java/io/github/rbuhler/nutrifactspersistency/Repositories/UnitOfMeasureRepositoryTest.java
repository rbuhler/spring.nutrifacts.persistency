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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NutrifactsPersistencyApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UnitOfMeasureRepositoryTest {

    @Autowired
    private UnitOfMeasureRepository repository;

    @Test
    private void findByIndex_givenUOMExists_shouldReturnUOM(){

            List<UnitOfMeasure>     UOMListPayload,
                                    UOMListActual,
                                    UOMListExpected;

            Long index = new Long(1);

            UOMListPayload = new ArrayList<>();
            UOMListExpected = new ArrayList<>();

            /** TODO **/
            /** IMPLEMENT FOR **/
            UOMListPayload.set(0, new UnitOfMeasure(Languages.PT_BR, "Kg", "Quilograma", "Peso"));
            UOMListPayload.set(1, new UnitOfMeasure(Languages.EN_US, "Kg", "Kilogram", "Weight"));
            UOMListPayload.set(2, new UnitOfMeasure(Languages.PT_BR, "Km", "Quilometro", "Distância"));
            UOMListPayload.set(3, new UnitOfMeasure(Languages.EN_US, "Km", "Kilometer", "Distance"));

            UOMListExpected.set(0, repository.findByIndex( UOMListPayload.get(0).getIndex() ));
            UOMListExpected.set(1, repository.findByIndex( UOMListPayload.get(1).getIndex() ));
            UOMListExpected.set(2, repository.findByIndex( UOMListPayload.get(2).getIndex() ));
            UOMListExpected.set(3, repository.findByIndex( UOMListPayload.get(3).getIndex() ));
            /** END FOR **/

            UOMListActual = UOMListPayload;

    }


}
