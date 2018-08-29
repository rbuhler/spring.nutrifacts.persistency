package io.github.rbuhler.nutrifactspersistency.Repositories;

import io.github.rbuhler.nutrifactspersistency.Entities.Partner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "partner", path = "partner")
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long> {

    Partner findByIndex(@Param("index") Long index);
}