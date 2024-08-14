package com.blackbird.licensingservice.service.client;

import com.blackbird.licensingservice.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// TODO: Umstellen für Docker produktion
// @FeignClient(name = "organization-service", url = "http://organization-service:8081")
@FeignClient(name = "organization-service", url = "http://localhost:8081")
public interface OrganizationFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/organization/{organizationId}", consumes = "application/json")
    Organization getOrganization(@PathVariable("organizationId") String organizationId);
}