package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.UnitOfMeasure;
import io.github.rbuhler.nutrifactspersistency.NutrifactsPersistencyApplication;
import io.github.rbuhler.nutrifactspersistency.localization.Languages;
import org.junit.Before;
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

    @Before
    public void setUp(){

        List<UnitOfMeasure>     UOMListPayload;
        UOMListPayload = new ArrayList<>();

        UOMListPayload.add(0, new UnitOfMeasure(Languages.PT_BR, "Kg", "Quilograma", "Peso"));
        UOMListPayload.add(1, new UnitOfMeasure(Languages.EN_US, "Kg", "Kilogram", "Weight"));
        UOMListPayload.add(2, new UnitOfMeasure(Languages.PT_BR, "Km", "Quilometro", "Distância"));
        UOMListPayload.add(3, new UnitOfMeasure(Languages.EN_US, "Km", "Kilometer", "Distance"));

        for(int count = 0; count < UOMListPayload.size(); count++ ) {
            repository.save(UOMListPayload.get(count));
        }
    }

    @Test
    public void findByShortId_givenUOMExists_shouldReturnUOM(){
        List<UnitOfMeasure>     UOMListExpected;
        UnitOfMeasure           UOMActual;

        UnitOfMeasure           UOM_pt_kg,
                                UOM_en_kg,
                                UOM_pt_km,
                                UOM_en_km;

        UOMListExpected = new ArrayList<>();

        UOM_pt_kg = new UnitOfMeasure(Languages.PT_BR, "Kg", "Quilograma", "Peso");
        UOM_pt_kg.setIndex(1L);

        UOM_en_kg =new UnitOfMeasure(Languages.EN_US, "Kg", "Kilogram", "Weight");
        UOM_en_kg.setIndex(2L);

        UOM_pt_km = new UnitOfMeasure(Languages.PT_BR, "Km", "Quilometro", "Distância");
        UOM_pt_km.setIndex(3L);

        UOM_en_km = new UnitOfMeasure(Languages.EN_US, "Km", "Kilometer", "Distance");
        UOM_en_km.setIndex(4L);

        UOMListExpected.add(0, UOM_pt_kg);
        UOMListExpected.add(1, UOM_en_kg);
        UOMListExpected.add(2, UOM_pt_km);
        UOMListExpected.add(3, UOM_en_kg);

        for(int count = 0; count < UOMListExpected.size(); count++ ){
            UOMActual = repository.findByShortIdAndLang( UOMListExpected.get(count).getShortId(), UOMListExpected.get(count).getLang() );
            assertReflectionEquals("Record ["+ count +"] failed.", UOMListExpected.get(count), UOMActual);
        }
    }
    @Test
    public void findByIndex_givenUOMExists_shouldReturnUOM(){
        List<UnitOfMeasure>     UOMListExpected;
        UnitOfMeasure           UOMActual,
                                UOM_pt_kg,
                                UOM_en_kg,
                                UOM_pt_km,
                                UOM_en_km;

        UOMListExpected = new ArrayList<>();

        UOM_pt_kg = new UnitOfMeasure(Languages.PT_BR, "Kg", "Quilograma", "Peso");
        UOM_pt_kg.setIndex(1L);

        UOM_en_kg =new UnitOfMeasure(Languages.EN_US, "Kg", "Kilogram", "Weight");
        UOM_en_kg.setIndex(2L);

        UOM_pt_km = new UnitOfMeasure(Languages.PT_BR, "Km", "Quilometro", "Distância");
        UOM_pt_km.setIndex(3L);

        UOM_en_km = new UnitOfMeasure(Languages.EN_US, "Km", "Kilometer", "Distance");
        UOM_en_km.setIndex(4L);

        UOMListExpected.add(0, UOM_pt_kg);
        UOMListExpected.add(1, UOM_en_kg);
        UOMListExpected.add(2, UOM_pt_km);
        UOMListExpected.add(3, UOM_en_km);

        for(int count = 0; count < UOMListExpected.size(); count++ ){
            Long index = new Long( count+1 );

            UOMActual = repository.findByIndex( index );
            assertReflectionEquals("Record ["+ count +"] failed.", UOMListExpected.get(count), UOMActual);
        }
    }
}