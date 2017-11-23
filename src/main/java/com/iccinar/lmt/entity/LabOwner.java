package com.iccinar.lmt.entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author iccinar
 * @date 20.09.2017.
 */
public enum LabOwner {
    GPS_ONLY("GPS Only"),
    DS_ONLY("DS Only"),
    GPS("GPS/DS ");

    @Autowired
    private String labOwner;

    LabOwner(String labOwner) {
        this.labOwner = labOwner;
    }

    public String getLabOwner() {
        return labOwner;
    }

    public void setLabOwner(String labOwner) {
        this.labOwner = labOwner;
    }
}
