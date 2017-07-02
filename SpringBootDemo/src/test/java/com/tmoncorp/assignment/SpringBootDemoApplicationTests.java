package com.tmoncorp.assignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tmoncorp.assignment.mapper.BoardMapper;
import com.tmoncorp.assignment.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringBootDemoApplicationTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSqlSession() throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setSubject("제목");
		boardVo.setContent("내용");
		boardVo.setWriter("작성자");
		boardMapper.boardInsert(boardVo);	
	}
	
}
