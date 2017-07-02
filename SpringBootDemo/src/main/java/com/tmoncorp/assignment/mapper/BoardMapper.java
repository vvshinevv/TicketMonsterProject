package com.tmoncorp.assignment.mapper;

import java.util.List;

import com.tmoncorp.assignment.vo.BoardVo;

public interface BoardMapper {
	public void boardInsert(BoardVo boardVo) throws Exception;
	public List<BoardVo> boardList() throws Exception;
	public BoardVo boardView(int bno) throws Exception;
	public void hitPlus(int bno);
	public void boardUpdate(BoardVo vo)throws Exception;
    public void boardDelete(int bno)throws Exception;
}
