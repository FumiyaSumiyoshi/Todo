package com.wiz.springboot.service;

import com.wiz.springboot.form.TodoForm;
import com.wiz.springboot.model.Todo;

public interface TodoService {

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
	public Todo deleteTodo(Long id);

}