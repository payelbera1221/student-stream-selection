package com.studentportal.dto.response;

import com.studentportal.entity.SubjectMark;
import com.studentportal.enums.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDTO {

    private String id;

    // Custom Student ID
    private String studentId;

    // Personal Details
    private String name;
    private String gender;
    private LocalDate dob;
    private Integer age;
    private String email;
    private String phone;
    private String schoolName;
    private LocalDate admissionDate;

    // Academic Details
    private Board board;
    private List<SubjectMark> subjects;
    private Double totalMarks;
    private Double percentage;
    private List<SubjectMark> updatedSubjects;
    private String recheckRemarks;
    private LocalDate recheckDate;

    // Stream Details
    private Stream eligibleStream;
    private Stream selectedStream;

    // Recheck
    private Boolean recheckRequested;

    // Management
    private Boolean managementRequested;
    private ManagementUpgrade managementUpgrade;

    // Status
    private StudentStatus studentStatus;
    private ApprovalStatus approvalStatus;

    // Remarks
    private String remarks;

    // Payment
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    private Double admissionFee;
    private String transactionId;
    private LocalDate paymentDate;
    private String paymentRemarks;

}
