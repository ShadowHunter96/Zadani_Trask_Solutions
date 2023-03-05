package com.shadowhunter.jpa.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shadowhunter.jpa.entity.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@ToString
@Entity
@Table(name = "Technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    private String tname;
    private String tuser;


    private int technologyLevel;
    private String technologyInfo;
    @ManyToMany(mappedBy = "technologies", fetch = FetchType.LAZY)
    @JsonProperty
    private Set<User> users;

}
