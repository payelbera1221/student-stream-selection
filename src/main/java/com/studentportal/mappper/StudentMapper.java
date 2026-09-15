package com.studentportal.mappper;

import com.studentportal.dto.request.StudentRequestDTO;
import com.studentportal.dto.response.StudentResponseDTO;
import com.studentportal.entity.Student;
import com.studentportal.enums.*;
import com.studentportal.util.StudentCalculationUtil;
import lombok.*;

public class StudentMapper {

    public static Student toEntity(StudentRequestDTO dto) {
        if (dto == null) return null;
        return Student.builder()
                .name(dto.getName())
                .gender(dto.getGender())
                .dob(dto.getDob())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .schoolName(dto.getSchoolName())
                .board(dto.getBoard())
                .subjects(dto.getSubjects())
                .recheckRequested(dto.getRecheckRequested())
                .build();
    }

    public static StudentResponseDTO toResponse(Student student) {
        if (student == null) return null;
        return StudentResponseDTO.builder()
                .id(student.getId())
                .studentId(student.getStudentId())
                .name(student.getName())
                .gender(student.getGender())
                .dob(student.getDob())
                .age(StudentCalculationUtil.calculateAge(student.getDob()))
                .email(student.getEmail())
                .phone(student.getPhone())
                .schoolName(student.getSchoolName())
                .admissionDate(student.getAdmissionDate())
                .board(student.getBoard())
                .subjects(student.getSubjects())
                .totalMarks(student.getTotalMarks())
                .percentage(student.getPercentage())
                .updatedSubjects(student.getUpdatedSubjects())
                .recheckRemarks(student.getRecheckRemarks())
                .recheckDate(student.getRecheckDate())
                .eligibleStream(student.getEligibleStream())
                .selectedStream(student.getSelectedStream())
                .recheckRequested(student.getRecheckRequested())
                .managementRequested(student.getManagementRequested())
                .managementUpgrade(student.getManagementUpgrade())
                .studentStatus(student.getStudentStatus())
                .approvalStatus(student.getApprovalStatus())
                .remarks(student.getRemarks())
                .paymentStatus(student.getPaymentStatus())
                .paymentMethod(student.getPaymentMethod())
                .admissionFee(student.getAdmissionFee())
                .transactionId(student.getTransactionId())
                .paymentDate(student.getPaymentDate())
                .paymentRemarks(student.getPaymentRemarks())
                .build();
    }
}
