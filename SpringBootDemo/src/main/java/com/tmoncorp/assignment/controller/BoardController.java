package com.tmoncorp.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tmoncorp.assignment.mapper.BoardMapper;
import com.tmoncorp.assignment.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView boardList() throws Exception {
		List<BoardVo> boardList = boardMapper.boardList();
		
		return new ModelAndView("boardList", "boardList", boardList);
	}
	
	@RequestMapping(value="/writeBoard", method=RequestMethod.GET)
	public ModelAndView writeForm() throws Exception {
		return new ModelAndView("writeBoard");
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(@ModelAttribute("BoardVo") BoardVo boardVo) throws Exception {
		boardMapper.boardInsert(boardVo);
		
		return "redirect://localhost:8080/board";
	}
	
	@RequestMapping(value="/{bno}", method=RequestMethod.GET)
	public ModelAndView boardView(@PathVariable("bno") int bno) throws Exception{
	    
	    BoardVo boardView = boardMapper.boardView(bno);
	    boardMapper.hitPlus(bno);
	    
	    return new ModelAndView("boardView", "boardView", boardView);
	}
	
	@RequestMapping(value="/update/{bno}", method=RequestMethod.GET)
	public ModelAndView updateView(@PathVariable("bno") int bno) throws Exception{
	        
	    BoardVo boardView = boardMapper.boardView(bno);
	    return new ModelAndView("updateBoard", "boardView", boardView);
	}
	
	@RequestMapping(value="/update/{bno}", method=RequestMethod.PATCH)
	public String update(@ModelAttribute("BoardVo")BoardVo board, @PathVariable("bno") int bno) throws Exception{
	        
	    boardMapper.boardUpdate(board);
	    return "redirect://localhost:8080/board/"+bno;
	}
	
	@RequestMapping(value="/{bno}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("bno") int bno) throws Exception{
	    boardMapper.boardDelete(bno);
	    return "redirect://localhost:8080/board";
	}	
}