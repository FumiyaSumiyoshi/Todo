package com.wiz.springboot.service;

import java.util.List;
import java.util.Optional;

import com.wiz.springboot.form.TodoForm;
import com.wiz.springboot.model.Todo;

public interface TodoService {
	
	/**
	 * ToDoリストの取得
	 * @return
	 */
	public List<Todo> findAll();
	
	/**
	 * ToDoリストの作成
	 * @param todoForm フォーム
	 * @return
	 */
	public Todo doInsert(TodoForm todoForm);

	/**
	 * ToDoリストを更新する
	 * @param todoForm フォーム
	 * @return
	 */
	public Todo editTodo(TodoForm todoForm);

	/**
	 * idをキーにToDoリストを削除する 論理削除
	 * @param id id
	 * @return
	 */
	public void deleteById(Long id);
	
	/**
	 * idをキーにレコードを取得する
	 * @param id
	 * @return
	 */
	public Optional<Todo> findById(Long id);

}