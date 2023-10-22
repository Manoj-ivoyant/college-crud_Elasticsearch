package com.ivoyant.elasticsearchdemocrud.service;

import com.ivoyant.elasticsearchdemocrud.model.College;
import com.ivoyant.elasticsearchdemocrud.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public College save(College college) {
        return collegeRepository.save(college);
    }

    public List<College> getByLocation(String location) {
        CriteriaQuery searchQuery = new CriteriaQuery(new Criteria("location").is(location));
        List<College> colleges = elasticsearchOperations.search(searchQuery, College.class)
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());

        return colleges;
    }

    public String deleteAll() {
        collegeRepository.deleteAll();
        return "deletion success";
    }

    public List<College> getByLocationContains(String location) {
        CriteriaQuery searchQuery = new CriteriaQuery(new Criteria("location").contains(location));
        List<College> colleges = elasticsearchOperations.search(searchQuery, College.class)
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());

        return colleges;
    }

    public List<College> getByLocationFuzzy(String location) {
        CriteriaQuery searchQuery = new CriteriaQuery(new Criteria("location").fuzzy(location));
        List<College> colleges = elasticsearchOperations.search(searchQuery, College.class)
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
        return colleges;
    }

    public List<College> getByLocationByStartsWith(String location) {
        CriteriaQuery searchQuery = new CriteriaQuery(new Criteria("location").startsWith(location));
        return elasticsearchOperations.search(searchQuery, College.class)
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());

    }

}

