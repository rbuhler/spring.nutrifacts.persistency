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

import java.sql.Timestamp;
import java.util.Date;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NutrifactsPersistencyApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void findByBarcode_givenItemExists_shouldReturnItemA(){
        Item itemPayload = getPayload();
        repository.save(itemPayload);
        assertReflectionEquals(itemPayload, repository.findByBarcode(itemPayload.getBarcode()));
    }

    @Test
    public void existsByBarcode_givenItemExists_shouldReturnTrue(){
        Item itemPayload = getPayload();
        repository.save(itemPayload);
        Assert.assertEquals( true, repository.existsByBarcode(itemPayload.getBarcode()) );
    }

    @Test
    public void findByIndex_givenItemExists_shouldReturnItem(){
        Item itemPayload = getPayload();
        repository.save(itemPayload);
        assertReflectionEquals(itemPayload, repository.findByIndex(1L));
    }

    public Item getPayload(){
        Item item = new Item(
                "1234567890123",
                "Product A",
                180,
                "gr",
                "http://www.picture.com/itemActual",
                18,
                "gr",
                100,
                "Nothing to say.");

        Item itemPayload = new Item();
        itemPayload.setBarcode(item.getBarcode());
        itemPayload.setIdentification(item.getIdentification());
        itemPayload.setImage(item.getImage());
        itemPayload.setIndex(item.getIndex());
        itemPayload.setQuantity(item.getQuantity());
        itemPayload.setUnitOfMeasure(item.getUnitOfMeasure());
        itemPayload.setServSize(item.getServSize());
        itemPayload.setServUom(item.getServUom());
        itemPayload.setServCalories(item.getServCalories());
        itemPayload.setDisclaimer(item.getDisclaimer());

        return  itemPayload;
    }

    protected static Timestamp now( ){
        return new Timestamp(new Date().getTime());
    }
}