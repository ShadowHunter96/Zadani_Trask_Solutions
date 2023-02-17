package com.shadowhunter.jpa.dto;

import com.shadowhunter.jpa.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserRequest {
    private User user;
}
