package com.wiz.springboot.todoJsonResponse;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wiz.springboot.response.JsonResponse;

import lombok.Data;

@Data
public class TodoJsonResponse extends JsonResponse {

	/**
	 * IDの定義
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * やることの定義
	 */
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
	private String addNote;

}
