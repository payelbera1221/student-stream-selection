package com.studentportal.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagementApprovalRequestDTO {
    private String studentId;
    private Boolean approved;
    private String remarks;
}
