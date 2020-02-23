package com.anamadeya.cpr.sl;

import com.anamadeya.cpr.bl.PartnerRegistationService;
import com.anamadeya.cpr.dl.schema.Anamadeya;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PartnerRegistrationController implements PartnerRegistrationSI {

    @Autowired
    PartnerRegistationService partnerRegistationService;

    @Override
    public ResponseEntity<String> register(@RequestBody Anamadeya anamadeya) {

        return ResponseEntity.ok(partnerRegistationService.register(anamadeya));
    }
}
