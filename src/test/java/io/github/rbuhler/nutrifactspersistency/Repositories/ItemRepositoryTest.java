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

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NutrifactsPersistencyApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void findByBarcode_givenItemExists_sholdReturnItemA(){
        Item    itemPayload,
                itemExpected,
                itemListActual;
        String  barcode = new String ("1234567890123");

        itemPayload = new Item("1234567890123", "Product A", 180, "gr", "http://www.picture.com/itemActual");
        repository.save(itemPayload);

        itemExpected = itemPayload;
        itemListActual = repository.findByBarcode(barcode);

        assertReflectionEquals(itemExpected, itemListActual);
    }
    @Test
    public void existsByBarcode_givenItemExists_sholdReturnTrue(){
        Item    itemPayload;
        Boolean itemExpected,
                itemListActual;
        String  barcode = new String ("1234567890123");

        itemPayload = new Item("1234567890123", "Product A", 180, "gr", "http://www.picture.com/itemActual");
        repository.save(itemPayload);

        itemExpected = true;
        itemListActual = repository.existsByBarcode(barcode);

        Assert.assertEquals(itemExpected, itemListActual);
    }
    @Test
    public void findByIndex_givenItemExists_sholdReturnItem(){
        Item    itemPayload,
                itemExpected,
                itemListActual;
        Long    index = new Long(1);

        itemPayload = new Item("1234567890123", "Product A", 180, "gr", "http://www.picture.com/itemActual");
        repository.save(itemPayload);

        itemExpected = itemPayload;
        itemListActual = repository.findByIndex(index);

        assertReflectionEquals(itemExpected, itemListActual);
    }
}