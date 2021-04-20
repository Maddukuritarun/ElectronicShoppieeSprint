package com.cg.es.service;


import java.util.List;

import com.cg.es.exception.UserException;
import com.cg.es.model.ChangePassword;
import com.cg.es.model.SignUp;
import com.cg.es.model.UserModel;

public interface IUserService {
	UserModel getUser(String userName) throws UserException;
	UserModel updateUser(UserModel userModel) throws UserException;
	UserModel add(UserModel user) throws UserException;	
	boolean signIn(UserModel user) throws UserException;	
	boolean signOut(UserModel user)throws UserException;
	void deleteUser(String userName);
	List<UserModel> getAll();
	boolean existsById(String userName);
	boolean changePassword(ChangePassword changePassword) throws UserException;
	UserModel signUp(SignUp signUp) throws UserException;
	UserModel findById(String userName);
	List<UserModel> findAll();
	

}
