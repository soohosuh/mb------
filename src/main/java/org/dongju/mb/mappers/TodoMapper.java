package org.dongju.mb.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dongju.mb.dto.PageRequestDTO;
import org.dongju.mb.dto.TodoDTO;

public interface TodoMapper {
  
  // 게시글을 추가하는 맵퍼
  int insert(TodoDTO todoDTO);

  // 모든 리스트를 가져오는 맵퍼
  List<TodoDTO> list(PageRequestDTO pageRequestDTO);

  // 1번에 리스트 몇개씩가져오는지 알려주는 맵퍼
  long listCount(PageRequestDTO pageRequestDTO);

  // 댓글수 기능
  public void updateReplyCnt(@Param("bno")Long bno, @Param("amount")
  int amount);

  // 게시글을 삭제하는 맵퍼
  int deleteOne(Long bno);

    
}
