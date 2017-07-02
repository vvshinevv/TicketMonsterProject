package com.tmoncorp.assignment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tmoncorp.assignment.service.BoardService;
import com.tmoncorp.assignment.vo.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView boardList() throws Exception {
		List<BoardVo> boardList = boardService.boardList();
		
		return new ModelAndView("boardList", "boardList", boardList);
	}
	
	@RequestMapping(value="/writeBoard", method=RequestMethod.GET)
	public ModelAndView writeForm() throws Exception {
		return new ModelAndView("writeBoard");
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(@ModelAttribute("BoardVo") BoardVo boardVo) throws Exception {
		
		boardService.boardInsert(boardVo);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value="/{bno}", method=RequestMethod.GET)
	public ModelAndView boardView(@PathVariable("bno") int bno) throws Exception{
	    
	    BoardVo boardView = boardService.boardView(bno);
	    boardService.hitPlus(bno);
	    
	    return new ModelAndView("boardView", "boardView", boardView);
	}
	
	@RequestMapping(value="/update/{bno}", method=RequestMethod.GET)
	public ModelAndView updateView(@PathVariable("bno") int bno) throws Exception{
	        
	    BoardVo boardView = boardService.boardView(bno);
	    return new ModelAndView("updateBoard", "boardView", boardView);
	}
	
	@RequestMapping(value="/update/{bno}", method=RequestMethod.POST)
	public String update(@ModelAttribute("BoardVo")BoardVo board, @PathVariable("bno") int bno) throws Exception{
	        
		boardService.boardUpdate(board);
	    return "redirect:/board/"+bno;
	}
	
	@RequestMapping(value="/{bno}", method=RequestMethod.POST)
	public String delete(@PathVariable("bno") int bno) throws Exception{
		boardService.boardDelete(bno);
	    return "redirect:/board";
	}	
}
