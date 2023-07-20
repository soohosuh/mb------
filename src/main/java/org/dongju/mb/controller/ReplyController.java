package org.dongju.mb.controller;

import java.util.Map;

import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.PageResponseDTO;
import org.dongju.mb.dto.ReplyDTO;
import org.dongju.mb.service.ReplyService;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/replies/")
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping(value = "{tno}/list")
    public PageResponseDTO<ReplyDTO> getReplyList(
        @PathVariable("tno") Long tno, PageRequestDTO pageRequestDTO){
        
        log.info("TNO: " + tno);

        return replyService.getList(tno, pageRequestDTO);
    }

    @PostMapping("{tno}/new")
    public Map<String, Long> insert(@PathVariable("tno") Long tno, @RequestBody ReplyDTO replyDTO) {
        
        replyDTO.setTno(tno);

        Long rno = replyService.register(replyDTO);

        log.info(replyDTO);

        return Map.of("result", rno);
    }   

    @GetMapping("{rno}")
    public ReplyDTO read(@PathVariable("rno") Long rno) {
        ReplyDTO replyDTO = replyService.readReply(rno);
        return replyDTO;
    }

  
    @DeleteMapping("{rno}")
    public Map<String, Integer> delete(@PathVariable("rno") Long rno) {
        int result = replyService.replyDelete(rno);
        return Map.of("result", result);
    }
    
}
