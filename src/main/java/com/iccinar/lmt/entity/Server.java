package com.iccinar.lmt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author iccinar
 * @date 30.10.2017.
 */

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Server {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "LOGICAL_IP")
    private String logicalIp;

    @NotNull
    @Column(name = "INSTANCE_TYPE")
    private String instanceType;

    @NotNull
    @Column(name = "HOST_NAME", nullable = false)
    private String hostName;

    @NotNull
    @Column(name = "HDWR_TYPE", nullable = false)
    private String hardwareType;

    @NotNull
    @Column(name = "A2_TYPE", nullable = false)
    private String a2Type;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LAB_ID", referencedColumnName = "ID")
    private Lab lab;

    public Server() {
    }

    public Server(String logicalIp, String instanceType, String hostName, String hardwareType, String a2Type, Lab lab) {
        this.logicalIp = logicalIp;
        this.instanceType = instanceType;
        this.hostName = hostName;
        this.hardwareType = hardwareType;
        this.a2Type = a2Type;
        this.lab = lab;
    }
}



