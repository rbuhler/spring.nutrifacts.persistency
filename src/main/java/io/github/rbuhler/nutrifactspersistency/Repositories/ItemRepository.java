package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Item;
import io.github.rbuhler.nutrifactspersistency.Entities.UnitOfMeasure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    Item findByIndex(@Param("index") Long index);

    Item findByBarcode(@Param("barcode") String barcode);
    Boolean existsByBarcode(@Param("barcode") String barcode);
}