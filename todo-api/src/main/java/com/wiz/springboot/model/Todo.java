package com.wiz.springboot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "list")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Todo {

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

	/**
	 * IDのsetter,getter
	 * 
	 * @return
	 */
	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	/**
	 * やることのsetter,getter
	 * 
	 * @return
	 */
	public String getToDo() {

		return toDo;

	}

	public void setToDo(String toDo) {

		this.toDo = toDo;

	}

	/**
	 * 更新日時のsetter,getter
	 * 
	 * @return
	 */
	public LocalDateTime getEditTime() {

		return editTime;

	}

	public void setEditTime(LocalDateTime editTime) {

		this.editTime = editTime;

	}

	/**
	 * 期限のsetter,getter
	 * 
	 * @return
	 */
	public LocalDateTime getTimeLimit() {

		return timeLimit;

	}

	public void setTimeLimit(LocalDateTime timeLimit) {

		this.timeLimit = timeLimit;

	}

	/**
	 * 到達度のsetter,getter
	 * 
	 * @return
	 */
	public String getMissionComp() {

		return missionComp;

	}

	public void setMissionComp(String missionComp) {

		this.missionComp = missionComp;

	}

	/**
	 * 備考のsetter,getter
	 * 
	 * @return
	 */
	public String getAddNote() {

		return addNote;

	}

	public void setAddNote(String addNote) {

		this.addNote = addNote;

	}

}
