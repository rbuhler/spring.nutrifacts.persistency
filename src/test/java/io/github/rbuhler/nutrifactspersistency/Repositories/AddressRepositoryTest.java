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

        payload.setAddress1("Street line 1");
        payload.setAddress2("Street line 2");
        payload.setAddress3("Street line 3");
        payload.setComplement("Complement for the address");
        payload.setPostalCode(956000000);
        payload.setCity("City");
        payload.setRegion("Country Region");
        payload.setCountry("Country");

        Address address = new Address(
                payload.getAddress1(),
                payload.getAddress2(),
                payload.getAddress3(),
                payload.getComplement(),
                payload.getPostalCode(),
                payload.getCity(),
                payload.getRegion(),
                payload.getCountry()
                );

        return address;
    }
}
