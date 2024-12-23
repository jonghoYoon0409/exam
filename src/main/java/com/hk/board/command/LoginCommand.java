package com.hk.board.command;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public class LoginCommand {
	
	@NotBlank(message = "아이디를 입력해주세요")
	private String id;
	
	@NotBlank(message = "패스워드를 입력해주세요")
	@Length(min =4  , max = 16, message = "8자리이상, 16자이하로 입력하세요")
	private String password;
	
	@Override
	public String toString() {
		return "LoginCommand [id=" + id + ", password=" + password + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginCommand(@NotBlank(message = "아이디를 입력해주세요") String id,
			@NotBlank(message = "패스워드를 입력해주세요") @Length(min = 8, max = 16, message = "8자리이상, 16자이하로 입력하세요") String password) {
		super(); //super()를 사용하는 이유는 부모 클래스의 생성자 호출을 통해 객체의 완전한 초기화를 보장하기 위해서입니다.
		         //부모 클래스가 가진 필드나 메서드가 올바르게 초기화되지 않으면, 자식 클래스에서 이를 사용할 때 예기치 않은 오류가 발생할 수 있습니다.
		this.id = id;
		this.password = password;
	}

	public LoginCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}



