package com.studentportal.service;

import com.studentportal.dto.request.*;
import com.studentportal.dto.response.StudentResponseDTO;
import com.studentportal.entity.Student;

import java.util.List;

public interface StudentService {
    StudentResponseDTO saveStudent(StudentRequestDTO dto);
    StudentResponseDTO selectStream(StreamSelectionRequestDTO dto);
    StudentResponseDTO approveStudent(ManagementApprovalRequestDTO dto);
    StudentResponseDTO makePayment(PaymentRequestDTO dto);
    StudentResponseDTO updateRecheck(RecheckRequestDTO dto);
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO getStudentById(String studentId);
    List<StudentResponseDTO> searchByName(String name);
    List<StudentResponseDTO> searchByStream(String stream);
    List<StudentResponseDTO> searchByStatus(String status);
    List<StudentResponseDTO> getManagementPendingStudents();
    List<StudentResponseDTO> getPaymentPendingStudents();
}
