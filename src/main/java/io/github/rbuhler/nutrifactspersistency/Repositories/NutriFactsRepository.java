package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.NutriFacts;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "nutrifacts", path = "nutrifacts")
public interface NutriFactsRepository extends PagingAndSortingRepository<NutriFacts, Long> {

    List<NutriFacts> findByItemId(@Param("itemId") Long itemId);

    NutriFacts findByItemIdAndNutrientId(@Param("itemId") Long itemId, @Param("nutrientId") Long nutrientId);
}
