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
	
	@Transactional(readOnly = true)
	public Page<Board> boardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board boardContent(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("閲覧失敗");
				});
	}
	
	@Transactional
	public void deleteId(int id) {
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void updateBoard(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("閲覧失敗");
				});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		//トランザクションが終了されdirtycheckingご、DBに自動的にアップデートされる。
	}
}
