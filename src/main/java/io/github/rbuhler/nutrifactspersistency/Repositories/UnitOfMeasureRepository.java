package io.github.rbuhler.nutrifactspersistency.Repositories;

import java.util.List;

import io.github.rbuhler.nutrifactspersistency.Entities.UnitOfMeasure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "uom", path = "uom")
public interface UnitOfMeasureRepository extends PagingAndSortingRepository<UnitOfMeasure, Long> {

    List<UnitOfMeasure> findByShortId(@Param("shortId") String shortId);
}