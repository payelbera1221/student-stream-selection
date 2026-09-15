package com.studentportal.dto.request;

import com.studentportal.entity.SubjectMark;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecheckRequestDTO {
    private String studentId;
    private List<SubjectMark> updatedSubjects;
    private String remarks;
}
