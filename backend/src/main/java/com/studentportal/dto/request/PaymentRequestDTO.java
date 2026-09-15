package com.studentportal.dto.request;

import com.studentportal.enums.PaymentMethod;
import lombok.Data;

@Data
public class PaymentRequestDTO {
    private String studentId;
    private PaymentMethod paymentMethod;
    private String transactionId;
    private String remarks;
}
