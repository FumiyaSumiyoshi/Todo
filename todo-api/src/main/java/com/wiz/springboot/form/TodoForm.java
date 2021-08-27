package com.wiz.springboot.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TodoForm {

	/**
	 * IDの定義
	 */
	private Long id;

	/**
	 * やることの定義
	 */
	@Size(min = 1, max = 50, message = "やることは50字以内で必ず入力しましょう")
	@NotBlank(message = "やることは必ず入力しましょう")
	private String toDo;

	/**
	 * 更新日時の定義
	 */
	private LocalDateTime editTime;

	/**
	 * 期限の定義
	 */
	private LocalDateTime timeLimit;

	/**
	 * 到達度の定義
	 */
	private String missionComp;

	/**
	 * 備考の定義
	 */
	@Size(max = 50, message = "備考は50字以内で入力しましょう")
	private String addNote;

}
