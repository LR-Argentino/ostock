package com.blackbird.licensingservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;


@Getter @Setter @ToString
public class Organization extends RepresentationModel<Organization> {
    private String id;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
}
