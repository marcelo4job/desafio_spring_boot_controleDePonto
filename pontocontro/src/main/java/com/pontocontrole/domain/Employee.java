package com.pontocontrole.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "registry")
    private String registry;
    @Column(name = "Role")
    private String role;
    @Column(name = "Departament")
    private String departament;


    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<RecordTime> records = new ArrayList<>();


//    @ManyToMany
//    @JoinTable(name =  "EMPLOYEE_TIMEBANK",
//            joinColumns = @JoinColumn(name="employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "banktime_id")
//    )
   // private TimeBank timeBank;




    //CONSTRUCTS
    public Employee(){

    }

    public Employee(Integer id, String name, String registry, String cargo, String departament) {
        this.id = id;
        this.name = name;
        this.registry = registry;
        this.role = cargo;
        this.departament = departament;
    }

    //GETS&SET'S


//    public TimeBank getTimeBank() {
//        return timeBank;
//    }
//
//    public void setTimeBank(TimeBank timeBank) {
//        this.timeBank = timeBank;
//    }

    public List<RecordTime> getRecords() {
        return records;
    }

    public void setRecords(List<RecordTime> records) {
        this.records = records;
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

    //HASHCOD&EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employer = (Employee) o;
        return Objects.equals(id, employer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
