package com.pontocontrole.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.net.SocketFlow;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TimeBank implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Status;
    private String NegBalance;
    private String profitBalance;



    //@ManyToMany(mappedBy = "timebank")
   // private List<Employee> employees = new ArrayList<>();


    public TimeBank(){

    }

    public TimeBank(String status, String negBalance, String profitBalance) {
        this.Status = status;
        this.NegBalance = negBalance;
        this.profitBalance = profitBalance;
    }

    public String getNegBalance() {
        return NegBalance;
    }

    public void setNegBalance(String negBalance) {
        NegBalance = negBalance;
    }

    public String getProfitBalance() {
        return profitBalance;
    }

    public void setProfitBalance(String profitBalance) {
        this.profitBalance = profitBalance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeBank timeBank = (TimeBank) o;
        return Objects.equals(id, timeBank.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
