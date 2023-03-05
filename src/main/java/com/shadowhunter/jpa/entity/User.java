package com.shadowhunter.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@ToString
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String technologyName;
    @Min(value = 1,message = "min must be 1")
    @Max(value = 10, message = "max must be 11")
    private int technologylevel;
    private String technologyinfo;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    @JoinTable(name = "user_id", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name ="technology_id"))
    @JsonProperty
    private Set<Technology> technologies = new HashSet<>();




}
