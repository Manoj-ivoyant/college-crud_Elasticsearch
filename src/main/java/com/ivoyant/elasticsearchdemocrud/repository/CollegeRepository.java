package com.ivoyant.elasticsearchdemocrud.repository;

import com.ivoyant.elasticsearchdemocrud.model.College;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CollegeRepository extends ElasticsearchRepository<College, String> {
    List<College> findAllByLocation(String location);
}
