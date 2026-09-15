package com.studentportal.repository;

import com.studentportal.entity.Student;
import com.studentportal.enums.ApprovalStatus;
import com.studentportal.enums.Stream;
import com.studentportal.enums.StudentStatus;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByApprovalStatus(ApprovalStatus status);

    List<Student> findBySelectedStream(Stream stream);

    List<Student> findByRecheckRequestedTrue();

    long countBySelectedStream(Stream stream);

    long countByApprovalStatus(ApprovalStatus approvalStatus);

    long countByRecheckRequestedTrue();

    // New methods
    Optional<Student> findByStudentId(String studentId);

    List<Student> findByStudentStatus(StudentStatus status);
}
