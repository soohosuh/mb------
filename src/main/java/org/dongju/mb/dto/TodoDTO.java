package org.dongju.mb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {

    private Long tno;
    private String title;
    private String writer;
    private String content;
    private boolean complete;
    private String dueDate;
    
}
