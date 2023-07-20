package org.dongju.mb.mappers;

import java.util.List;

import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.TodoDTO;

public interface TodoMapper {
  
  int insert(TodoDTO todoDTO);

  List<TodoDTO> list(PageRequestDTO pageRequestDTO);

  long listCount(PageRequestDTO pageRequestDTO);

    
}
