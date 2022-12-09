package com.ltp.gradesubmission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Grade {
    private String id;
    private String name;
    private String subject;
    private String score;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }
}
