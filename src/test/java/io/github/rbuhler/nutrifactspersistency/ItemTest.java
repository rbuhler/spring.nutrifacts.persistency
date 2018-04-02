package io.github.rbuhler.nutrifactspersistency;

import io.github.rbuhler.nutrifactspersistency.Entities.Item;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemTest {

    @Autowired
    private TestEntityManager entityManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Item itemA;
    private Item itemB;
    private Item itemC;

    @Before
    public void setup(){
        itemA = new Item("1234567890123", "Procdutc A", 300, "gr", "http://wwww.picture.com/A");
        itemB = new Item("0987654321098", "Procdutc B", 180, "lt", "http://wwww.picture.com/B");
        itemC = new Item("1029384756021", "Procdutc C", 3, "kg" , "http://wwww.picture.com/C");
    }

}
/* https://ajayiyengar.com/2017/07/08/testing-jpa-entities-in-a-spring-boot-application/ */