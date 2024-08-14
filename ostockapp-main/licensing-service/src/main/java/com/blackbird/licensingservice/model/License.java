package com.blackbird.licensingservice.model;

import com.blackbird.licensingservice.model.idclass.LicenseId;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "licenses")
@Getter @Setter @ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@IdClass(LicenseId.class)
@EqualsAndHashCode
public class License extends RepresentationModel<License> {
	@Id
	@Column(name = "license_id", nullable = false)
	private String licenseId;
	private String description;
	@Id
	@Column(name = "organization_id", nullable = false)
	private String organizationId;
	@Column(name = "product_name", nullable = false)
	private String productName;
	@Column(name = "license_type", nullable = false)
	private String licenseType;
	@Column(name = "comment")
	private String comment;
	@Transient
	private String organizationName;
	@Transient
	private String contactName;
	@Transient
	private String contactPhone;
	@Transient
	private String contactEmail;

	public License withComment(String comment) {
		this.setComment(comment);
		return this;
	}
}
