package com.pontocontrole.dto;

import com.pontocontrole.domain.Employee;
import com.pontocontrole.domain.RecordTime;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecordTimeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalTime time;
    private LocalDate date;
    private String dayOfWeek;

    private Employee employee;

    public RecordTimeDTO(){

    }

    public RecordTimeDTO(RecordTime obj){

        id = obj.getId();
        time = obj.getTime();
        date = obj.getDate();
        dayOfWeek = obj.getDayOfWeek();

        employee = obj.getEmployee();

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
