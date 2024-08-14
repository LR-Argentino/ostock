package com.blackbird.licensingservice.model.idclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter @Setter
public class LicenseId implements Serializable {
    private String licenseId;
    private String organizationId;
}
