package org.dongju.mb.service;

import java.util.List;

import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.PageResponseDTO;
import org.dongju.mb.dto.ReplyDTO;
import org.dongju.mb.mappers.ReplyMapper;
import org.dongju.mb.mappers.TodoMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyMapper replyMapper;
    private final TodoMapper todoMapper;

    @Override
    public Long register(ReplyDTO replyDTO) {
        
        Long result = null;
        Long gno = replyDTO.getGno();

        if(gno == 0L){
            int count = replyMapper.insert(replyDTO);

            if(count != 1){
                throw new RuntimeException("Reply Insert Exception");
            }

            Long rno = replyDTO.getRno();
            replyMapper.updateGno(rno);
            result = rno;
        } else {
            int count = replyMapper.insertChild(replyDTO);

            if(count != 1){
                throw new RuntimeException("Reply Insert Exception");
            }
        }

        return result;
    }

    @Override
    public PageResponseDTO<ReplyDTO> getList(Long tno, PageRequestDTO pageRequestDTO) {
        
        pageRequestDTO.setSize(100);

        List<ReplyDTO> list = replyMapper.selectList(tno, pageRequestDTO);
        int total = replyMapper.getTnoCount(tno);

        return PageResponseDTO.<ReplyDTO>withAll()
        .list(list)
        .total(total)
        .build();
    }

    @Override
    public ReplyDTO getOne(Long tno) {
        
        return replyMapper.selectOne(tno);
    }

    @Override
    public int replyDelete(Long rno) {

        ReplyDTO bnoDTO= replyMapper.selectOne(rno);

        todoMapper.updateReplyCnt(bnoDTO.getGno(),-1);
        return replyMapper.replyDelete(rno);
        
    }

    @Override
    public int updateReply(ReplyDTO replyDTO) {

        return replyMapper.updateReply(replyDTO);
        
    }


    
}
