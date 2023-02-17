package com.shadowhunter.jpa.dto;

import com.shadowhunter.jpa.entity.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TechnologyRequest {
    private Technology technology;
}
