package com.cg.es.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SignUp {
	
	@NotNull(message="user id cannot be null")	
	@NotBlank(message="user id cannot be blank")
	@Pattern(regexp="^[A-Za-z][A-Za-z0-9]{3,20}$")
	private String userName;
	
	@NotNull(message="Key cannot be null")	
	@NotBlank(message="Key cannot be blank")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,10}$")
	private String key;
	
	@NotNull(message="Create password cannot be null")	
	@NotBlank(message="Create password cannot be blank")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\\S+$).{8,30}$")
	private String createPassword;
	
	@NotNull(message="confirm password cannot be null")	
	@NotBlank(message="confirm password cannot be blank")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\\S+$).{8,30}$")
	private String confirmPassword;
	
	
	public SignUp() {
		
	}


	public SignUp(
			@NotNull(message = "user id cannot be null") @NotBlank(message = "user id cannot be blank") @Pattern(regexp = "^[A-Za-z][A-Za-z0-9]{3,20}$") String userName,
			@NotNull(message = "Key cannot be null") @NotBlank(message = "Key cannot be blank") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,10}$") String key,
			@NotNull(message = "Create password cannot be null") @NotBlank(message = "Create password cannot be blank") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\\S+$).{8,30}$") String createPassword,
			@NotNull(message = "confirm password cannot be null") @NotBlank(message = "confirm password cannot be blank") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\\S+$).{8,30}$") String confirmPassword) {
		super();
		this.userName = userName;
		this.key = key;
		this.createPassword = createPassword;
		this.confirmPassword = confirmPassword;
	}
	
	


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getCreatePassword() {
		return createPassword;
	}


	public void setCreatePassword(String createPassword) {
		this.createPassword = createPassword;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + ((createPassword == null) ? 0 : createPassword.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUp other = (SignUp) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (createPassword == null) {
			if (other.createPassword != null)
				return false;
		} else if (!createPassword.equals(other.createPassword))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SignUp [userName=" + userName + ", key=" + key + ", createPassword=" + createPassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}


	
	
	

}
