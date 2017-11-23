package com.iccinar.lmt.controller;

import com.iccinar.lmt.Repository.LabRepository;
import com.iccinar.lmt.Repository.ServerRepository;
import com.iccinar.lmt.entity.Lab;
import com.iccinar.lmt.entity.LabOwner;
import com.iccinar.lmt.entity.LabRelease;
import com.iccinar.lmt.entity.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iccinar
 * @date 18.10.2017.
 */
@RestController
@RequestMapping(value = "services/")
public class GenericController  {

    @Autowired
    LabRepository labRepository;

    @Autowired
    ServerRepository serverRepository;


    @RequestMapping(value = "labRelease", method = RequestMethod.GET)
    public LabRelease[] findAllLabRelease() {
        return LabRelease.values();
    }

    @RequestMapping(value = "labOwner", method = RequestMethod.GET)
    public LabOwner[] findAllLabOwners() {
        return LabOwner.values();
    }

    @RequestMapping(value = "createLab", method = RequestMethod.POST)
    public Lab create(@RequestBody Lab lab) {
        return labRepository.saveAndFlush(lab);
    }

    @RequestMapping(value = "addServer", method = RequestMethod.POST)
    public Server addServer(@RequestBody Server server) {
        return serverRepository.saveAndFlush(server);
    }


    @RequestMapping(value = "lab/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Lab lab = labRepository.findOne(id);
        labRepository.delete(lab);
    }

    @RequestMapping(value = "labs", method = RequestMethod.GET)
    public List<Lab> list() {
        List<Lab> xx = labRepository.findAll();
        return labRepository.findAll();
    }

    @RequestMapping(value = "servers/{id}", method = RequestMethod.GET)
    public List<Server> list(@PathVariable Long id) {
        List<Server> xx = serverRepository.findByLabId(id);
        return serverRepository.findByLabId(id);
    }

    @RequestMapping(value = "servers/{id}", method = RequestMethod.DELETE)
    public void deleteServer(@PathVariable Long id) {
        Server server = serverRepository.findOne(id);
        serverRepository.delete(server);
    }
}

