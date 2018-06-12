package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Item;
import io.github.rbuhler.nutrifactspersistency.Entities.UnitOfMeasure;
import io.github.rbuhler.nutrifactspersistency.Enum.Greatness;
import io.github.rbuhler.nutrifactspersistency.Enum.Languages;
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

    private String getKiloGramShortId(Languages lang){
        UnitOfMeasure kiloGram;
        kiloGram = new UnitOfMeasure(lang,
                "gr",
                "Kilogram",
                Greatness.MASS);
        return kiloGram.getShortId();
    };

    @Test
    public void findByBarcode_givenItemExists_shouldReturnItemA(){
        Item    itemPayload,
                itemExpected,
                itemListActual;
        String  barcode = new String ("1234567890123");

        itemPayload = new Item(
                "1234567890123",
                "Product A",
                180,
                getKiloGramShortId(Languages.PT_BR),
                "http://www.picture.com/itemActual",
                18,
                getKiloGramShortId(Languages.PT_BR),
                100,
                "Nothing do say");
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

        itemPayload = new Item(
                "1234567890123",
                "Product A",
                180,
                getKiloGramShortId(Languages.PT_BR),
                "http://www.picture.com/itemActual",
                18,
                getKiloGramShortId(Languages.PT_BR),
                100,
                "Nothing to say.");
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

        itemPayload = new Item(
                "1234567890123",
                "Product A",
                180,
                getKiloGramShortId(Languages.PT_BR),
                "http://www.picture.com/itemActual",
                18,
                getKiloGramShortId(Languages.PT_BR),
                100,
                "Nothing to say.");
        repository.save(itemPayload);

        itemExpected = itemPayload;
        itemListActual = repository.findByItemId(index);

        assertReflectionEquals(itemExpected, itemListActual);
    }
    @Test
    public void getter_setter(){
        Item    actualItem,
                expectedItem;

        actualItem = new Item(
                "1234567890123",
                "Product A",
                180,
                getKiloGramShortId(Languages.PT_BR),
                "http://www.picture.com/itemActual",
                18,
                getKiloGramShortId(Languages.PT_BR),
                100,
                "Nothing to say.");
        expectedItem = new Item();

        expectedItem.setBarcode(actualItem.getBarcode());
        expectedItem.setIdentification(actualItem.getIdentification());
        expectedItem.setImage(actualItem.getImage());
        expectedItem.setItemId(actualItem.getItemId());
        expectedItem.setQuantity(actualItem.getQuantity());
        expectedItem.setUnitOfMeasure(actualItem.getUnitOfMeasure());
        expectedItem.setServSize(actualItem.getServSize());
        expectedItem.setServUom(actualItem.getServUom());
        expectedItem.setServCalories(actualItem.getServCalories());
        expectedItem.setDisclaimer(actualItem.getDisclaimer());
    }

    protected static Timestamp now( ){
        return new Timestamp(new Date().getTime());
    }
}