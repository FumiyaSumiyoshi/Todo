package com.wiz.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiz.springboot.model.Todo;
import com.wiz.springboot.repositoly.TodoRepository;

/**
 * ToDoリストRESTコントローラークラス
 */
@RestController
public class TodoController {

	@Autowired
	TodoRepository todoRepository;

	/**
	 * GETリクエストによって全件取得して表示するためのメソッド
	 * 
	 * @return
	 */
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public List<Todo> Get() {

		// 全件取得
		List<Todo> list = todoRepository.findAll();

		return list;

	}

	/**
	 * POSTリクエストによって新しいレコードを追加するためのメソッド
	 * 
	 * @param todoList
	 * @return
	 */
	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public List<Todo> Post(@RequestBody List<Todo> todoList) {

		// 新しいデータの保存
		List<Todo> result = todoRepository.saveAll(todoList);

		return result;

	}

	/**
	 * PUTリクエストによって既存のデータを編集するためのメソッド
	 * 
	 * @param todo
	 * @return
	 */
	@RequestMapping(value = "/todo", method = RequestMethod.PUT)
	public Todo Put(@RequestBody Todo todo) {

		// 指定されたIDのレコードを取得
		Optional<Todo> target = todoRepository.findById(todo.getId());

		if (target.isEmpty()) {

			// 指定されたIDが見つからない場合は何もせず終了
			return null;

		} else {

			// 指定されたIDのデータを更新
			todoRepository.save(todo);

			return target.get();

		}

	}

	/**
	 * DELETEリクエストによって既存のデータを削除するためのメソッド
	 * 
	 * @param todo
	 * @return
	 */
	@RequestMapping(value = "/todo", method = RequestMethod.DELETE)
	public Todo Delete(@RequestBody Todo todo) {
		// 指定されたIDのレコードを取得
		Optional<Todo> target = todoRepository.findById(todo.getId());

		if (target.isEmpty()) {

			// 指定されたIDが見つからない場合は何もせず終了

			return null;

		} else {

			//指定されたIDのデータを削除
			todoRepository.deleteById(target.get().getId());

			return target.get();

		}

	}

}
