package com.blackbird.licensingservice.service;

import com.blackbird.licensingservice.config.ServiceConfig;
import com.blackbird.licensingservice.model.License;
import com.blackbird.licensingservice.model.Organization;
import com.blackbird.licensingservice.repository.LicenseRepository;
import com.blackbird.licensingservice.service.client.OrganizationFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LicenseService {
	
	@Autowired
	MessageSource messages;
	@Autowired
	private LicenseRepository licenseRepository;
	@Autowired
	ServiceConfig config;
	@Autowired
	private OrganizationFeignClient organizationFeignClient;

	/***
	 * Hier verwenden wir den @CircuitBreaker weil wir einen anderen Service aufrufen
	 * @param licenseId
	 * @param organizationId
	 * @return
	 */
	@CircuitBreaker(name = "licenseService")
	public License getLicense(final String licenseId,final String organizationId) {
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		if (license == null) {
			throw new IllegalArgumentException(String.format(messages.getMessage(
					"license.search.error.message", null, null), licenseId, organizationId));
		}
		Organization organization = organizationFeignClient.getOrganization(organizationId);
		if (organization != null) {
			license.setOrganizationId(organization.getId());
			license.setContactName(organization.getContactName());
			license.setContactPhone(organization.getContactPhone());
			license.setContactEmail(organization.getContactEmail());
		}
		return license.withComment(config.getProperty());
	}

	public License createLicense(License license){
		license.setLicenseId(UUID.randomUUID().toString());
		licenseRepository.save(license);
		return license.withComment(config.getProperty());
	}

	public License updateLicense(License license){
		licenseRepository.save(license);
		return license.withComment(config.getProperty());
	}

	public String deleteLicense(String licenseId){
		String responseMessage = null;
		License license = new License();
		license.setLicenseId(licenseId);
		licenseRepository.delete(license);
		responseMessage = String.format(messages.getMessage(
				"license.delete.message", null, null), licenseId);
		return responseMessage;
	}
}
