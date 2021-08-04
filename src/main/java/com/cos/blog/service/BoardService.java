package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Board> boardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	public Board boardContent(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("閲覧失敗");
				});
	}
}
