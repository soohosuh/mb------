package org.dongju.mb.service;

import java.util.List;

import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.PageResponseDTO;
import org.dongju.mb.dto.TodoDTO;
import org.dongju.mb.mappers.TimeMapper;
import org.dongju.mb.mappers.TodoMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TimeMapper timeMapper;
    private final TodoMapper todoMapper;
    

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        
        List<TodoDTO> list = todoMapper.list(pageRequestDTO);
        long total = todoMapper.listCount(pageRequestDTO);

        return PageResponseDTO.<TodoDTO>withAll()
        .list(list)
        .total(total)
        .build();
    }
    
}
