package com.studentportal.dto.request;

import com.studentportal.enums.Board;
import com.studentportal.entity.SubjectMark;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {
    private String name;
    private String gender;
    private LocalDate dob;
    private String email;
    private String phone;
    private String schoolName;
    private Board board;
    private List<SubjectMark> subjects;
    private Boolean recheckRequested;
}
