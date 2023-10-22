package com.ivoyant.elasticsearchdemocrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "college")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class College implements Serializable {
    @Id
    private String collegeId;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String collegeName;
    @Field(type = FieldType.Text)
    private String location;
    @Field(type = FieldType.Integer)
    private Integer noOfStudents;
}
