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

        addressPayload = new Address(
                "Rua Joao Lourenco Shaeffer",
                "Bairro Centro",
                "Edificio Dona Lili",
                "Complment",
                95630000,
                "Igrejinha",
                "RS",
                "Brasil"
        );

        repository.save(addressPayload);

        addressExpected = addressPayload;
        addressActual = repository.findByIndex(1l);

        assertReflectionEquals(addressExpected, addressActual);
    }
}