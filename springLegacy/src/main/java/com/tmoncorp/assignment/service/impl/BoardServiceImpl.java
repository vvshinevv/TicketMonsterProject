package com.tmoncorp.assignment.service.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.tmoncorp.assignment.service.BoardService;
import com.tmoncorp.assignment.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl extends SqlSessionDaoSupport implements BoardService{

	@Override
	public void boardInsert(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		getSqlSession().insert("board.boardInsert", boardVo);
	}

	@Override
	public List<BoardVo> boardList() throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("board.boardList");
	}

	@Override
	public BoardVo boardView(int bno) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("board.boardView", bno);
	}

	@Override
	public void hitPlus(int bno) {
		getSqlSession().update("board.hitPlus", bno);
	}

	@Override
	public void boardUpdate(BoardVo vo) throws Exception {
		getSqlSession().update("board.boardUpdate", vo);
		
	}

	@Override
	public void boardDelete(int bno) throws Exception {
		getSqlSession().delete("board.boardDelete", bno);
	}

}
