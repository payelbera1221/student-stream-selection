package com.studentportal.dto.request;

import com.studentportal.enums.Stream;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StreamSelectionRequestDTO {
    private String studentId;
    private Stream selectedStream;
}
