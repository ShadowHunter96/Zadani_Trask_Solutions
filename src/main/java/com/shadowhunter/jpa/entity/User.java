package com.shadowhunter.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String technology;
    @Min(value = 1,message = "min must be 1")
    @Max(value = 10, message = "max must be 11")
    private int technologylevel;
    private String technologyinfo;
    @OneToMany(targetEntity = Technology.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ut_fk", referencedColumnName = "id")
    private List<Technology> technologies;




}
