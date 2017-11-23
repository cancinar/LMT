package com.iccinar.lmt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author iccinar
 * @date 18.10.2017.
 */
@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lab {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "LAB_NAME")
    private String labName;

    @NotNull
    @Column(name = "LAB_PRIME")
    private String labPrime;

    @NotNull
    @Column(name = "LAB_SERVICE_IP", nullable = false)
    private String serviceIp;

    @Column(name = "LAB_OWNER", nullable = false)
    @Enumerated(EnumType.STRING)
    private LabOwner labOwner;

    @NotNull
    @Column(name = "PROV1_IP", nullable = false)
    private String prov1Ip;

    @NotNull
    @Column(name = "PROV2_IP", nullable = false)
    private String prov2Ip;

    @Column(name = "LAB_RELEASE")
    @Enumerated(EnumType.STRING)
    private LabRelease labRelease;

    @OneToMany
    private Set<Server> servers;


    public Lab() {
    }

    public Lab(String labName, String labPrime, String serviceIp, LabOwner labOwner, LabRelease labRelease, Set<Server> servers) {
        this.labName = labName;
        this.labPrime = labPrime;
        this.serviceIp = serviceIp;
        this.labOwner = labOwner;
        this.labRelease = labRelease;
        this.servers = servers;
    }
}
