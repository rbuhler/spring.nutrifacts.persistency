package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Item;
import io.github.rbuhler.nutrifactspersistency.NutrifactsPersistencyApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NutrifactsPersistencyApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void findById_givenItemAExists_sholdReturnItemA(){
        Item itemA;

        itemA = new Item("1234567890123", "Product A", 180, "gr", "http://www.picture.com/itemA");

        repository.save(itemA);

        Assert.assertEquals(itemA, repository.findById(itemA.getId()));

    }
}
/** TODO
 * https://www.petrikainulainen.net/programming/testing/writing-clean-tests-naming-matters/
  */