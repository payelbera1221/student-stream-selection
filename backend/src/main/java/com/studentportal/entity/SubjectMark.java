package com.studentportal.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectMark {
    private String subjectName;
    private Integer marks;
}