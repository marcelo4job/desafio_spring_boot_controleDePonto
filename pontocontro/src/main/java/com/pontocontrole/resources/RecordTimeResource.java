package com.pontocontrole.resources;


import com.pontocontrole.domain.RecordTime;

import com.pontocontrole.dto.RecordTimeDTO;

import com.pontocontrole.services.RecordTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "recordTime")
public class RecordTimeResource {

    @Autowired
    private RecordTimeService recordTimeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        RecordTime obj = recordTimeService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody RecordTimeDTO objDto) {
        RecordTime obj = recordTimeService.fromDTO(objDto);
        obj = recordTimeService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
