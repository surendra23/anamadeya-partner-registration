package com.anamadeya.cpr.sl;

import com.anamadeya.cpr.dl.schema.Anamadeya;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(tags = PartnerRegistrationSI.Constants.API_NAME)
public interface PartnerRegistrationSI {

    final class Constants {
        public static final String API_NAME = "partner-registration";
        public static final String REQUEST_MAPPING_PATH = "/" + API_NAME + "/v1";
        public static final String VERSION = "1.0.0";

        private Constants() {
            //suppressed public constructor
        }
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "Partner registered successfully.")})
    @ApiOperation(
            nickname = "register",
            value = "register partner.")
    @RequestMapping(
            value = Constants.REQUEST_MAPPING_PATH + "/register",
            method =  RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<String> register(@RequestBody Anamadeya anamadeya);
}
