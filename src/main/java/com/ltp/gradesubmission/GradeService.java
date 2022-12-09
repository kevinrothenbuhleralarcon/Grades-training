package com.ltp.gradesubmission;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GradeService {

    public static Integer getGrade(final List<Grade> grades, final String id) {
        OptionalInt indexOpt = IntStream.range(0, grades.size())
                .filter(i -> grades.get(i).getId().equals(id))
                .findFirst();
        return indexOpt.isPresent() ? indexOpt.getAsInt() : null;
    }
}
