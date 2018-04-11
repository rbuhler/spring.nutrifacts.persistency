package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Manufacturer;
import io.github.rbuhler.nutrifactspersistency.Entities.UnitOfMeasure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "manufacturer", path = "manufacturer")
public interface ManufacturerRepository extends PagingAndSortingRepository<Manufacturer, Long> {

    Manufacturer findByIndex(@Param("index") Long index);
}