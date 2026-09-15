package com.studentportal.service.impl;

import com.studentportal.dto.request.*;
import com.studentportal.dto.response.StudentResponseDTO;
import com.studentportal.entity.Student;
import com.studentportal.enums.*;
import com.studentportal.mappper.StudentMapper;
import com.studentportal.service.StudentService;
import com.studentportal.repository.StudentRepository;
import com.studentportal.util.StudentCalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponseDTO saveStudent(StudentRequestDTO dto) {
        Student student = StudentMapper.toEntity(dto);
        // Calculate total and percentage
        int total = StudentCalculationUtil.calculateTotal(dto.getBoard(), dto.getSubjects());
        double percentage = StudentCalculationUtil.calculatePercentage(dto.getBoard(), total);
        student.setTotalMarks((double) total);
        student.setPercentage(percentage);
        // Determine eligible stream
        Stream eligible = StudentCalculationUtil.calculateEligibleStream(percentage);
        student.setEligibleStream(eligible);
        // Generate custom studentId (simple UUID based)
        student.setStudentId(java.util.UUID.randomUUID().toString());
        student.setAdmissionDate(java.time.LocalDate.now());
        // Set initial statuses
        student.setStudentStatus(StudentStatus.REGISTERED);
        student.setApprovalStatus(ApprovalStatus.PENDING);
        student.setPaymentStatus(PaymentStatus.NOT_REQUIRED);
        student.setManagementRequested(false);
        studentRepository.save(student);
        return StudentMapper.toResponse(student);
    }

    @Override
    public StudentResponseDTO selectStream(StreamSelectionRequestDTO dto) {
        Optional<Student> opt = studentRepository.findByStudentId(dto.getStudentId());
        if (!opt.isPresent()) return null;
        Student student = opt.get();
        student.setSelectedStream(dto.getSelectedStream());
        // Update status based on selection
        if (dto.getSelectedStream() == Stream.MANAGEMENT) {
            student.setManagementRequested(true);
            student.setStudentStatus(StudentStatus.MANAGEMENT_PENDING);
        } else {
            student.setStudentStatus(StudentStatus.STREAM_SELECTED);
        }
        studentRepository.save(student);
        return StudentMapper.toResponse(student);
    }

    @Override
    public StudentResponseDTO approveStudent(ManagementApprovalRequestDTO dto) {
        Optional<Student> opt = studentRepository.findByStudentId(dto.getStudentId());
        if (!opt.isPresent()) return null;
        Student student = opt.get();
        if (dto.getApproved()) {
            student.setApprovalStatus(ApprovalStatus.APPROVED);
            student.setStudentStatus(StudentStatus.PAYMENT_PENDING);
            student.setPaymentStatus(PaymentStatus.PENDING);
        } else {
            student.setApprovalStatus(ApprovalStatus.REJECTED);
            student.setStudentStatus(StudentStatus.REJECTED);
        }
        studentRepository.save(student);
        return StudentMapper.toResponse(student);
    }

    @Override
    public StudentResponseDTO makePayment(PaymentRequestDTO dto) {
        Optional<Student> opt = studentRepository.findByStudentId(dto.getStudentId());
        if (!opt.isPresent()) return null;
        Student student = opt.get();
        // Set payment method directly from DTO enum
        student.setPaymentMethod(dto.getPaymentMethod());
        student.setTransactionId(dto.getTransactionId());
        student.setPaymentDate(java.time.LocalDate.now());
        student.setPaymentRemarks(dto.getRemarks());
        student.setPaymentStatus(PaymentStatus.PAID);
        student.setStudentStatus(StudentStatus.ACTIVE);
        studentRepository.save(student);
        return StudentMapper.toResponse(student);
    }

    @Override
    public StudentResponseDTO updateRecheck(RecheckRequestDTO dto) {
        Optional<Student> opt = studentRepository.findByStudentId(dto.getStudentId());
        if (!opt.isPresent()) return null;
        Student student = opt.get();
        student.setUpdatedSubjects(dto.getUpdatedSubjects());
        student.setRecheckRemarks(dto.getRemarks());
        student.setRecheckDate(java.time.LocalDate.now());
        student.setRecheckRequested(true);
        // Recalculate total & percentage based on updated subjects
        int total = StudentCalculationUtil.calculateTotal(student.getBoard(), dto.getUpdatedSubjects());
        double percentage = StudentCalculationUtil.calculatePercentage(student.getBoard(), total);
        student.setTotalMarks((double) total);
        student.setPercentage(percentage);
        student.setEligibleStream(StudentCalculationUtil.calculateEligibleStream(percentage));
        studentRepository.save(student);
        return StudentMapper.toResponse(student);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO getStudentById(String studentId) {
        return studentRepository.findByStudentId(studentId)
                .map(StudentMapper::toResponse)
                .orElse(null);
    }

    @Override
    public List<StudentResponseDTO> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name).stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTO> searchByStream(String stream) {
        Stream s = Stream.valueOf(stream.toUpperCase());
        return studentRepository.findBySelectedStream(s).stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTO> searchByStatus(String status) {
        StudentStatus s = StudentStatus.valueOf(status.toUpperCase());
        return studentRepository.findByStudentStatus(s).stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTO> getManagementPendingStudents() {
        return studentRepository.findByStudentStatus(StudentStatus.MANAGEMENT_PENDING).stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTO> getPaymentPendingStudents() {
        return studentRepository.findByStudentStatus(StudentStatus.PAYMENT_PENDING).stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }
}
