package org.rainzha.justhibernate.annotations;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private int id = 0;
    private String name = null;

}
