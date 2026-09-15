package com.studentportal.controlller;

import com.studentportal.dto.request.*;
import com.studentportal.dto.response.StudentResponseDTO;
import com.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentResponseDTO> saveStudent(@RequestBody StudentRequestDTO dto) {
        return ResponseEntity.ok(studentService.saveStudent(dto));
    }

    @PostMapping("/select-stream")
    public ResponseEntity<StudentResponseDTO> selectStream(@RequestBody StreamSelectionRequestDTO dto) {
        return ResponseEntity.ok(studentService.selectStream(dto));
    }

    @PostMapping("/approve")
    public ResponseEntity<StudentResponseDTO> approve(@RequestBody ManagementApprovalRequestDTO dto) {
        return ResponseEntity.ok(studentService.approveStudent(dto));
    }

    @PostMapping("/payment")
    public ResponseEntity<StudentResponseDTO> payment(@RequestBody PaymentRequestDTO dto) {
        return ResponseEntity.ok(studentService.makePayment(dto));
    }

    @PostMapping("/recheck")
    public ResponseEntity<StudentResponseDTO> recheck(@RequestBody RecheckRequestDTO dto) {
        return ResponseEntity.ok(studentService.updateRecheck(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable String studentId) {
        StudentResponseDTO dto = studentService.getStudentById(studentId);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<StudentResponseDTO>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.searchByName(name));
    }

    @GetMapping("/search/stream/{stream}")
    public ResponseEntity<List<StudentResponseDTO>> searchByStream(@PathVariable String stream) {
        return ResponseEntity.ok(studentService.searchByStream(stream));
    }

    @GetMapping("/search/status/{status}")
    public ResponseEntity<List<StudentResponseDTO>> searchByStatus(@PathVariable String status) {
        return ResponseEntity.ok(studentService.searchByStatus(status));
    }

    @GetMapping("/management-pending")
    public ResponseEntity<List<StudentResponseDTO>> managementPending() {
        return ResponseEntity.ok(studentService.getManagementPendingStudents());
    }

    @GetMapping("/payment-pending")
    public ResponseEntity<List<StudentResponseDTO>> paymentPending() {
        return ResponseEntity.ok(studentService.getPaymentPendingStudents());
    }
}
