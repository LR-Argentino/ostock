package com.blackbird.organizationservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class DTOOrganization {
    private String type;
    private String action;
    private String organizationId;
    private String correlationId;

    public DTOOrganization(String type, String action, String organizationId, String correlationId) {
        this.type = type;
        this.action = action;
        this.organizationId = organizationId;
        this.correlationId = correlationId;
    }
}
