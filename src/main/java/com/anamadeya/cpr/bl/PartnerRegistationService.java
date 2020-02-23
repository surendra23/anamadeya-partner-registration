package com.anamadeya.cpr.bl;

import com.anamadeya.cpr.dl.dao.AnamadeyaDao;
import com.anamadeya.cpr.dl.schema.Anamadeya;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PartnerRegistationService {

    @Autowired
    AnamadeyaDao anamadeyaDao;

    public String register(Anamadeya anamadeya) {
        try {
            anamadeyaDao.register(anamadeya);
        } catch (JsonProcessingException e) {
            log.error("Exception while adding anamadeya {}, cause{}, message {}",anamadeya.getFirstName() , e.getCause(), e.getMessage());
            return "Exception while adding anamadeya";
        }
        return "Anamadeya regisred successfully";
    }
}
