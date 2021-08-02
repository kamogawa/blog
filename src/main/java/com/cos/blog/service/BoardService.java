package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.BlogUser;
import com.cos.blog.model.Board;
import com.cos.blog.repository.BoardRepository;

@Service
public class BoardService {
	
	//DI
	@Autowired
	public BoardRepository boardRepository;

	@Transactional
	public void createBoard(Board board, BlogUser blogUser) {
		board.setUser(blogUser);
		board.setCount(0);
		boardRepository.save(board);
	}
}
