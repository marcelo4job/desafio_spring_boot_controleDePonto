package com.pontocontrole.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class RecordTime implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Time")
    private LocalTime time = LocalTime.now();
    @Column(name = "Date")
    private LocalDate date = LocalDate.now();
    @Column(name = "DayofWeek")
    private Integer dayOfWeek;
    @Column(name = "Status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "employeeCod")
    private Employee employee;

    //CONSTRUCTS

    public RecordTime(){

    }

    public RecordTime(Integer id, LocalTime time, LocalDate date, Integer dayOfWeek, Integer status, Employee employee) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.status = status;
        this.employee = employee;
    }

    //GET&SET'S


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

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    //HASH&CODES


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordTime that = (RecordTime) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
