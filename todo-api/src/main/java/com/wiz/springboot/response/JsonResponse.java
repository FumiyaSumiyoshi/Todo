package com.wiz.springboot.response;

import java.util.Map;

import lombok.Data;

@Data
public class JsonResponse {

	/**
	 * 成功かどうか
	 */
	private Boolean success;

	/**
	 * メッセージ
	 */
	private String message;

	/**
	 * エラーメッセージ
	 */
	private Map<String, String> errors;

}
