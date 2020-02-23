package com.anamadeya.cpr.dl.schema;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Identity {
    enum Proof{
        AADHAR,
        VOTER_ID,
        PAN
    }

    String id;
    String number;
    String idCopy;

}
