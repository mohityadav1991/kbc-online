package com.kbc.service;

import com.kbc.dao.jpa.VendorRepository;
import com.kbc.domain.Reward;
import com.kbc.domain.Vendor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorService {

    private static final Logger log = LoggerFactory.getLogger(VendorService.class);

    @Autowired
    private VendorRepository vendorRepository;



    public VendorService() {
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}
