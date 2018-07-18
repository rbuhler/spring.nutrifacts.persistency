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
        Address payload;
        payload = new Address();

        Address address = new Address(
            "Street line 1",
            "Street line 2",
            "Street line 3",
            "Complement for the address",
            956000000,
            "City",
            "Country Region",
            "Country"
        );

        payload.setIndex(address.getIndex());
        payload.setAddress1(address.getAddress1());
        payload.setAddress2(address.getAddress2());
        payload.setAddress3(address.getAddress3());
        payload.setComplement(address.getComplement());
        payload.setPostalCode(address.getPostalCode());
        payload.setCity(address.getCity());
        payload.setRegion(address.getRegion());
        payload.setCountry(address.getCountry());

        return payload;
    }
}