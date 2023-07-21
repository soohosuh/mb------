package org.dongju.mb.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyDTO {

    private Long rno;
    
    private Long tno;
        
    private Long gno;
    
    private String reply;

    private String replyer;
    
    private LocalDate replyDate;
    
}
