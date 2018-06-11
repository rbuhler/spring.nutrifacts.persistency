package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Partner;
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
public class PartnerTest {

    @Autowired
    PartnerRepository repository;

    @Before
    public void setUp(){
        List<Partner> partnerListPayload;
        partnerListPayload = new ArrayList<>();

        partnerListPayload.add( 0, new Partner("Partner A Co", "Super Partner Co"));
        partnerListPayload.add( 1, new Partner("Partner B Co", "Super Partner Co"));

        for (int count = 0; count < partnerListPayload.size(); count++){
            repository.save(partnerListPayload.get(count));
        }
    }
    @Test
    public void findById_givenCompanyExists_shouldReturnCompany(){
        Partner expectedPartnerA,
                expectedPartnerB,
                actualPartner;

        expectedPartnerA = new Partner("Partner A Co", "Super Partner Co");
        expectedPartnerA.setIndex(1L);
        expectedPartnerB = new Partner("Partner B Co", "Super Partner Co");
        expectedPartnerB.setIndex(2L);

        actualPartner = repository.findByIndex(1L);
        assertReflectionEquals("Manufacturer A comparison failed", expectedPartnerA, actualPartner);

        actualPartner = repository.findByIndex(2L);
        assertReflectionEquals("Manufacturer B  comparison failed", expectedPartnerB, actualPartner);

    }
}
