package com.shadowhunter.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
