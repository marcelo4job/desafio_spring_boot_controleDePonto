package com.pontocontrole.domain;

import com.pontocontrole.domain.enums.DayOfWeekEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
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
    private LocalTime time;
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "DayofWeek")
    private String dayOfWeek;




    @ManyToOne
    @JoinColumn(name = "timebank")
    private Employee employee;



    //CONSTRUCTS

    public RecordTime(){

    }

    public RecordTime(Integer id, LocalTime time, LocalDate date, DayOfWeekEnum dayOfWeek, Employee employee) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.dayOfWeek = (dayOfWeek == null) ?  null: dayOfWeek.getDesc();

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
        return time = time;
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
