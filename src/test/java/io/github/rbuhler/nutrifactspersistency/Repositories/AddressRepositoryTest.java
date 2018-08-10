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
        Address addressPayload = getPayload();
        repository.save(addressPayload);
        assertReflectionEquals(addressPayload, repository.findByIndex(1L));
    }

    private Address getPayload(){
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

        Address addressPayload = new Address();
        addressPayload.setIndex(address.getIndex());
        addressPayload.setAddress1(address.getAddress1());
        addressPayload.setAddress2(address.getAddress2());
        addressPayload.setAddress3(address.getAddress3());
        addressPayload.setComplement(address.getComplement());
        addressPayload.setPostalCode(address.getPostalCode());
        addressPayload.setCity(address.getCity());
        addressPayload.setRegion(address.getRegion());
        addressPayload.setCountry(address.getCountry());

        return addressPayload;
    }
}