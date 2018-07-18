package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Nutrient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "nutrient", path="nutrient")
public interface NutrientRepository extends PagingAndSortingRepository<Nutrient, Long> {

    Nutrient findByIndex(@Param("index") Long index);

}
