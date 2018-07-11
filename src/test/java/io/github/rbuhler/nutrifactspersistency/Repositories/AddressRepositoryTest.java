package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Address;
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
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository repository;

    @Test
    public void findByIndex_givenIndexExists_shouldReturnAddressA(){
        Address addressPayload,
                addressExpected,
                addressActual;

        Long index = new Long(1);

        addressPayload = getPayload();

        repository.save(addressPayload);

        addressExpected = addressPayload;
        addressActual = repository.findByIndex(index);

        assertReflectionEquals(addressExpected, addressActual);

    }

    private Address getPayload(){
        String address1 = "Street line 1";
        String address2 = "Street line 2";
        String address3 = "Street line 3";
        String complement = "Complement for the address";
        Integer postalCode = 956000000;
        String city = "City";
        String region = "Country Region";
        String country = "Country";

        Address address = new Address( address1, address2, address3,complement,postalCode,city,region,country);

        return address;
    }
}
