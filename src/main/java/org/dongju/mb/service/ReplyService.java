package org.dongju.mb.service;

import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.PageResponseDTO;
import org.dongju.mb.dto.ReplyDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReplyService {

    Long register(ReplyDTO replyDTO);

    PageResponseDTO<ReplyDTO> getList(Long tno, PageRequestDTO pageRequestDTO);

    ReplyDTO getOne(Long tno);

    int replyDelete(Long rno);

    int updateReply(ReplyDTO replyDTO);
    
}
