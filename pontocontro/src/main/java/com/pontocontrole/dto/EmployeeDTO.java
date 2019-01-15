package com.pontocontrole.dto;

import com.pontocontrole.domain.Employee;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String registry;
    private String role;
    private String departament;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Employee obj){
        id = obj.getId();
        name = obj.getName();
        registry = obj.getRegistry();
        role = obj.getRole();
        departament = obj.getDepartament();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
}
