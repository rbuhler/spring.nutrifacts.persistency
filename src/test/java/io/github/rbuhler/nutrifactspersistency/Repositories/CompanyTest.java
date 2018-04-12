package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Company;
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
public class CompanyTest {

    @Autowired
    CompanyRepository repository;

    @Before
    public void setUp(){
        List<Company> companyListPayload;
        companyListPayload = new ArrayList<>();

        companyListPayload.add( 0, new Company("Company A Co", "Super Company Co"));
        companyListPayload.add( 1, new Company("Company B Co", "Super Company Co"));

        for (int count=0; count < companyListPayload.size(); count++){
            repository.save(companyListPayload.get(count));
        }
    }
    @Test
    public void findById_givenCompanyExists_shouldReturnCompany(){
        Company expectedCompanyA,
                expectedCompanyB,
                actualCompany;

        expectedCompanyA = new Company("Company A Co", "Super Company Co");
        expectedCompanyA.setIndex(1L);
        expectedCompanyB = new Company("Company B Co", "Super Company Co");
        expectedCompanyB.setIndex(2L);

        actualCompany = repository.findByIndex(1L);
        assertReflectionEquals("Manufacturer A comparison failed", expectedCompanyA, actualCompany);

        actualCompany = repository.findByIndex(2L);
        assertReflectionEquals("Manufacturer B  comparison failed", expectedCompanyB, actualCompany);

    }
}
