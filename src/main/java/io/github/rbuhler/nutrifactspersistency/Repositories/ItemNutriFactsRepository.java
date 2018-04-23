package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.ItemNutriFacts;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemNutriFactsRepository extends PagingAndSortingRepository<ItemNutriFacts, Long> {
    /** ITEM KEY */
    List<ItemNutriFacts> findByItem(@Param("item") Long item);

    /** ITEM AND INDEX KEY */
    ItemNutriFacts findByItemAndIndex(@Param("item") Long item, @Param("index") Long index);
}
