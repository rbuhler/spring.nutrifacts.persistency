package io.github.rbuhler.nutrifactspersistency.Repositories;

import java.util.List;

import io.github.rbuhler.nutrifactspersistency.Entities.Item;
import io.github.rbuhler.nutrifactspersistency.Entities.UnitOfMeasure;
import io.github.rbuhler.nutrifactspersistency.localization.Languages;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "uom", path = "uom")
public interface UnitOfMeasureRepository extends PagingAndSortingRepository<UnitOfMeasure, Long> {

    /* INDEX KEY */
    UnitOfMeasure findByIndex(@Param("index") Long index);

    /* SHORT ID KEY */
    UnitOfMeasure findByShortId(@Param("shortId") String shortId, @Param("lang") String lang);
    Boolean existsByShortId(@Param("shortId") String shortId, @Param("lang") Languages lang);

}