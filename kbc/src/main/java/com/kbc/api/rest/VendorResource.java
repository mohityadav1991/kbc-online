package com.kbc.api.rest;
import com.kbc.domain.Vendor;
import com.kbc.service.VendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/kbc/v1/vendors")
public class VendorResource {

    @Autowired
    private VendorService vendorService;

    private static final Logger log = LoggerFactory.getLogger(VendorResource.class);

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createVendor(@RequestBody Vendor reward,
                             HttpServletRequest request, HttpServletResponse response) {
        Vendor createdVendor = this.vendorService.createVendor(reward);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdVendor.getVendorid()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Vendor> getAllVendor(HttpServletRequest request, HttpServletResponse response){

        return this.vendorService.getAllVendors();
    }
}
