package com.blackbird.organizationservice.controller;

import com.blackbird.organizationservice.model.Organization;
import com.blackbird.organizationservice.service.OrganizationService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="v1/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService service;


    @GetMapping(value="/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.PUT)
    public void updateOrganization( @PathVariable("organizationId") String id, @RequestBody Organization organization) {
        service.update(organization);
    }

    @PostMapping
    public ResponseEntity<Organization>  saveOrganization(@RequestBody Organization organization) {
    	return ResponseEntity.ok(service.create(organization));
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization( @PathVariable("id") String id,  @RequestBody Organization organization) {
        service.delete(organization);
    }

    @GetMapping
    public ResponseEntity<String> getText() {
        return ResponseEntity.ok("Hello");
    }

}
