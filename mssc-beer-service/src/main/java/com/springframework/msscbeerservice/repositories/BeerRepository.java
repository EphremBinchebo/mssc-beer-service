package com.springframework.msscbeerservice.repositories;

import com.springframework.msscbeerservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {


}
