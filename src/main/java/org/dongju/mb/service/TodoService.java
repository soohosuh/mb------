package org.dongju.mb.service;

import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.PageResponseDTO;
import org.dongju.mb.dto.TodoDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoService {

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
    
    

    
}
