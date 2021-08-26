package com.wiz.springboot.TodoJsonResponse;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wiz.springboot.response.JsonResponse;

import lombok.Data;

@Data
@Entity
@Table(name = "list")
public class TodoJsonResponse extends JsonResponse {

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
	private String addNote;

}
