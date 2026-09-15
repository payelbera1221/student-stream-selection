package com.studentportal.util;

import com.studentportal.enums.Board;
import com.studentportal.enums.Stream;
import com.studentportal.entity.SubjectMark;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

public class StudentCalculationUtil {

    private StudentCalculationUtil() {}

    public static int calculateAge(LocalDate dob) {
        if (dob == null) return 0;
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public static int calculateTotal(Board board, List<SubjectMark> subjects) {
        if (subjects == null || subjects.isEmpty()) {
            return 0;
        }
        if (board == Board.WB) {
            // WB board: sum of all 7 subjects
            return subjects.stream().mapToInt(SubjectMark::getMarks).sum();
        }
        // CBSE/ICSE: top 5 subjects
        return subjects.stream()
                .map(SubjectMark::getMarks)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double calculatePercentage(Board board, int total) {
        if (board == Board.WB) {
            return total / 7.0;
        }
        return total / 5.0;
    }

    public static Stream calculateEligibleStream(double percentage) {
        if (percentage >= 90) return Stream.COMPUTER_SCIENCE;
        if (percentage >= 81) return Stream.BIO_SCIENCE;
        if (percentage >= 71) return Stream.COMMERCE;
        if (percentage >= 50) return Stream.ARTS;
        return null; // Not eligible
    }
}
