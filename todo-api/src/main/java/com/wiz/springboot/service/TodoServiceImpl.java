package com.wiz.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiz.springboot.exception.IdNotFoundException;
import com.wiz.springboot.exception.NotFoundException;
import com.wiz.springboot.form.TodoForm;
import com.wiz.springboot.model.Todo;
import com.wiz.springboot.repositoly.TodoRepository;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	/**
	 * リポジトリ
	 */
	@Autowired
	private TodoRepository todoRepository;

	/**
	 * ToDoリストの作成
	 *
	 * @param todoForm フォーム
	 * @return
	 */
	@Override
	public Todo doInsert(TodoForm todoForm) {
		Todo todo = new Todo();
		// 同じプロパティ同士で内容をコピー
		BeanUtils.copyProperties(todoForm, todo);
		return todoRepository.save(todo);
	}

	/**
	 * ToDoリストを更新する
	 *
	 * @param todoForm フォーム
	 * @return
	 */
	@Override
	public Todo editTodo(TodoForm todoForm) {
		Todo todo = new Todo();

		if (todoForm == null) {
			throw new NotFoundException("対象のレコードが見つかりません。");
		}

		BeanUtils.copyProperties(todoForm, todo);

		return todoRepository.save(todo);
	}

	/**
	 * idをキーにToDoリストを削除する 論理削除
	 *
	 * @param id id
	 * @return
	 */
	@Override
	public Todo deleteTodo(Long id) {

		if (id == null) {

			throw new IdNotFoundException("指定したidがありません。");
		}

		Todo todo = todoRepository.getById(id);

		if (todo == null) {

			throw new NotFoundException("対象のレコードが見つかりません。");

		}

		return todoRepository.save(todo);

	}

}
