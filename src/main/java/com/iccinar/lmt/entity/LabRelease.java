package com.iccinar.lmt.entity;

/**
 * @author iccinar
 * @date 20.09.2017.
 */
public enum LabRelease {
    AS_103("10.3"),
    AS_104("10.4"),
    AS_110("11.0"),
    AS_112("11.2"),
    AS_120("12.0"),
    AS_121("12.1");

    private String labRelease;

    LabRelease(String labRelease) {
        this.labRelease = labRelease;
    }

    public String getLabRelease() {
        return labRelease;
    }

    public void setLabRelease(String labRelease) {
        this.labRelease = labRelease;
    }
}