package com.ltp.gradesubmission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Grade {
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Subject cannot be blank")
    private String subject;
    @Score(message = "Score must be a letter grade")
    private String score;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }
}
