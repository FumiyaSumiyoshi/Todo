package com.wiz.springboot.form;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "list")
public class TodoForm {

	/**
	 * IDの定義
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * やることの定義
	 */
	@Column(name = "toDo")
	@Size(min = 1, max = 50, message = "やることは50字以内で必ず入力しましょう")
	private String toDo;

	/**
	 * 更新日時の定義
	 */
	@Column(name = "edit_time")
	private LocalDateTime editTime;

	/**
	 * 期限の定義
	 */
	@Column(name = "time_limit")
	private LocalDateTime timeLimit;

	/**
	 * 到達度の定義
	 */
	@Column(name = "mission_comp")
	private String missionComp;

	/**
	 * 備考の定義
	 */
	@Column(name = "add_note")
	@Size(max = 50, message = "備考は50字以内で入力しましょう")
	private String addNote;

}
