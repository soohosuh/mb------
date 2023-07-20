package org.dongju.mb.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.ReplyDTO;

public interface ReplyMapper {
    
    int insert(ReplyDTO replyDTO);

    //대댓글일떄
    int insertChild(ReplyDTO replyDTO);

    // gno값 일치
    int updateGno (Long rno);

    // 1개의 게시글읽기 
    ReplyDTO selectOne(Long rno);

    // 댓글을 게시글에서 가져오기
    List<ReplyDTO> selectList(
        @Param("tno")Long tno, 
        @Param("page")PageRequestDTO pageRequestDTO);

    // total 
    int getTnoCount(Long tno);

    // reply delete 
    int replyDelete(Long rno);

    // reply update 
    int updateReply(ReplyDTO replyDTO);


}
