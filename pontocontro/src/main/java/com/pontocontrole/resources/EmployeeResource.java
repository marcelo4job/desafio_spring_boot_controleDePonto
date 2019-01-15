package com.pontocontrole.resources;

import com.pontocontrole.domain.Employee;
import com.pontocontrole.dto.EmployeeDTO;
import com.pontocontrole.repositories.EmployeeRepository;
import com.pontocontrole.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "employee")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Employee obj = employeeService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody EmployeeDTO objDto) {
        Employee obj = employeeService.fromDTO(objDto);
        obj = employeeService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
