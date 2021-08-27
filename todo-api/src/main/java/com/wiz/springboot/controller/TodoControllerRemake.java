package com.wiz.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wiz.springboot.form.TodoForm;
import com.wiz.springboot.model.Todo;
import com.wiz.springboot.repositoly.TodoRepository;
import com.wiz.springboot.service.TodoService;
import com.wiz.springboot.todoJsonResponse.TodoJsonResponse;

/**
 * ToDoリストRESTコントローラークラス
 */
@RestController
public class TodoControllerRemake {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	TodoService todoService;

	/**
	 * GETリクエストによって全件取得して表示するためのメソッド
	 * 
	 * @return
	 */
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public List<Todo> read() {

		// 全件取得
		List<Todo> list = todoService.findAll();

		return list;

	}

	/**
	 * POSTリクエストによって新しいレコードを追加するためのメソッド
	 * 
	 * @param todoForm
	 * @param errorResult
	 * @return
	 */
	@RequestMapping(value = "/todo/create", method = RequestMethod.POST)
	@ResponseBody
	public TodoJsonResponse create(@Validated @RequestBody TodoForm todoForm, BindingResult errorResult) {

		TodoJsonResponse todoJsonResponse = new TodoJsonResponse();
		todoJsonResponse.setToDo(todoForm.getToDo());
		todoJsonResponse.setEditTime(todoForm.getEditTime());
		todoJsonResponse.setTimeLimit(todoForm.getTimeLimit());
		todoJsonResponse.setMissionComp(todoForm.getMissionComp());
		todoJsonResponse.setAddNote(todoForm.getAddNote());

		// 入力チェック
		if (errorResult.hasErrors()) {
			// エラーメッセージをマップに詰め替え
			Map<String, String> errors = errorResult.getFieldErrors().stream()
					.collect(
							Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

			todoJsonResponse.setSuccess(false);
			todoJsonResponse.setMessage("入力エラーがあります。");
			todoJsonResponse.setErrors(errors);

			return todoJsonResponse;

		}

		// インサート
		Todo todo = todoService.doInsert(todoForm);

		if (todo == null) {

			throw new RuntimeException("作成に失敗しました。");

		} else {

			todoJsonResponse.setSuccess(true);
			todoJsonResponse.setMessage("作成しました。");

		}

		return todoJsonResponse;

	}

	/**
	 * PUTリクエストによって既存のデータを編集するためのメソッド
	 * 
	 * @param id
	 * @param todoForm
	 * @param errorResult
	 * @return
	 */
	@RequestMapping(value = "/todo/{id}/edit", method = RequestMethod.PUT)
	@ResponseBody
	public TodoJsonResponse edit(@PathVariable Long id, @Validated @RequestBody TodoForm todoForm,
			BindingResult errorResult) {

		TodoJsonResponse todoJsonResponse = new TodoJsonResponse();
		todoJsonResponse.setId(todoForm.getId());
		todoJsonResponse.setToDo(todoForm.getToDo());
		todoJsonResponse.setEditTime(todoForm.getEditTime());
		todoJsonResponse.setTimeLimit(todoForm.getTimeLimit());
		todoJsonResponse.setMissionComp(todoForm.getMissionComp());
		todoJsonResponse.setAddNote(todoForm.getAddNote());

		// 入力チェック
		if (errorResult.hasErrors()) {
			// エラーメッセージをマップに詰め替え
			Map<String, String> errors = errorResult.getFieldErrors().stream()
					.collect(
							Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

			todoJsonResponse.setSuccess(false);
			todoJsonResponse.setMessage("入力エラーがあります。");
			todoJsonResponse.setErrors(errors);

			return todoJsonResponse;

		}

		//更新
		Todo todo = todoService.editTodo(todoForm);

		if (todo == null) {

			throw new RuntimeException("更新に失敗しました。");

		} else {

			todoJsonResponse.setSuccess(true);
			todoJsonResponse.setMessage("更新しました。");

		}

		return todoJsonResponse;

	}

	/**
	 * DELETEリクエストによって既存のデータを削除するためのメソッド
	 * 
	 * @param id
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value = "/todo/{id}/delete", method = RequestMethod.DELETE)
	public TodoJsonResponse delete(@PathVariable Long id, RedirectAttributes attributes) {

		// 指定されたIDのレコードを取得
		Optional<Todo> target = todoService.findById(id);
//		Optional<Todo> target = todoService.findById(id);

		TodoJsonResponse todoJsonResponse = new TodoJsonResponse();

		if (target.isEmpty()) {
			
			// 指定されたIDが見つからない場合は何もせず終了
			todoJsonResponse.setMessage("削除に失敗しました。");

		} else {

			todoJsonResponse.setSuccess(true);
			todoJsonResponse.setMessage("削除しました。");

			//指定されたIDのデータを削除
			todoService.deleteById(target.get().getId());

		}

		return todoJsonResponse;

	}

}
