package com.batchtest.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CsvDTO {
    private String gnn;
    private int allViewCount;
}
