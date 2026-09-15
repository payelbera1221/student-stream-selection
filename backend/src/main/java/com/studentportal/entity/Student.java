package com.studentportal.entity;

import com.studentportal.enums.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    // Custom Student ID
    private String studentId;

    // Personal details
    private String name;

    private String gender;

    private LocalDate dob;

    private String email;

    private String phone;

    private String schoolName;

    private LocalDate admissionDate;

    // Academic details
    private Board board;

    private List<SubjectMark> subjects;

    private Double totalMarks;

    private Double percentage;

    private List<SubjectMark> updatedSubjects;

    private String recheckRemarks;

    private LocalDate recheckDate;

    // Stream details
    private Stream eligibleStream;

    private Stream selectedStream;

    // Recheck
    private Boolean recheckRequested;

    private String remarks;

    // Management
    private Boolean managementRequested;

    private ManagementUpgrade managementUpgrade;

    // Payment
    private PaymentStatus paymentStatus;

    private PaymentMethod paymentMethod;

    private Double admissionFee;

    private String transactionId;

    private LocalDate paymentDate;

    private String paymentRemarks;

    // Approval
    private ApprovalStatus approvalStatus;

    // General status
    private StudentStatus studentStatus;
}