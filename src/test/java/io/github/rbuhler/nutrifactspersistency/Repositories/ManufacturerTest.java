package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Manufacturer;
import io.github.rbuhler.nutrifactspersistency.NutrifactsPersistencyApplication;
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
public class ManufacturerTest {

    @Autowired
    ManufacturerRepository repository;

    @Before
    public void setUp(){
        List<Manufacturer> manufacturerListPayload;
        manufacturerListPayload = new ArrayList<>();

        manufacturerListPayload.add( 0, new Manufacturer("Company A ltd", "Super Company A"));
        manufacturerListPayload.add( 1, new Manufacturer("Company B ltd", "Super Company B"));

        for (int count=0; count < manufacturerListPayload.size(); count++){
            repository.save(manufacturerListPayload.get(count));
        }
    }
    @Test
    public void findById_givenManufacturerExists_shouldReturnManufacturer(){

        Manufacturer    expectedManufacturerA,
                        expectedManufacturerB,
                        actualManufacturer;

        expectedManufacturerA = new Manufacturer("Company A ltd", "Super Company A");
        expectedManufacturerA.setIndex(1L);
        expectedManufacturerB = new Manufacturer("Company B ltd", "Super Company B");
        expectedManufacturerB.setIndex(2L);

        actualManufacturer = repository.findByIndex(1L);
        assertReflectionEquals("Manufacturer A comparison failed", expectedManufacturerA, actualManufacturer);

        actualManufacturer = repository.findByIndex(2L);
        assertReflectionEquals("Manufacturer B  comparison failed", expectedManufacturerB, actualManufacturer);

    }


}

