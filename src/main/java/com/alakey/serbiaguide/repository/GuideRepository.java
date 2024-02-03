package com.alakey.serbiaguide.repository;

import com.alakey.serbiaguide.entity.Guide;
import org.springframework.data.repository.CrudRepository;

public interface GuideRepository extends CrudRepository<Guide, Long> {
}