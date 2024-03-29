package com.cg.es.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.es.repository.UserRepository;
import com.cg.es.entity.User;
import com.cg.es.exception.UserException;
import com.cg.es.model.ChangePassword;
import com.cg.es.model.SignUp;
import com.cg.es.model.UserModel;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EMParser parser;
	
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
		this.parser = new EMParser();
	}

	
	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public EMParser getParser() {
		return parser;
	}

	public void setParser(EMParser parser) {
		this.parser = parser;
	}



	@Override
	public UserModel add(UserModel user) throws UserException {
		if(user==null) {
			throw new UserException("user should not be null");
		}
		if(user !=null) {
		if(userRepo.existsById(user.getUserName())) {
			throw new UserException("User "+user.getUserName()+" is already Exists");
		}
		if(!user.getUserName().matches("^[A-Za-z][A-Za-z0-9]{3,20}$")) {
			throw new UserException("UserId should be non empty and minimum of length 4");
		}
		if(!user.getUserPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&()])(?=\\S+$).{8,}$")) {
			throw new UserException("Password should contain upper case, Lower case, Special charecter, numbers and length minimum 8");
		}
		else {
			user=parser.parse(userRepo.save(parser.parse(user)));
		}
		}
		return user;
	}


	@Override
	public boolean signIn(UserModel user) throws UserException {
		if(user==null) {
			throw new UserException("SignIn details Cannot be Null");
		}
		User userDetails=userRepo.findById(user.getUserName()).orElse(null);
		if(userDetails==null) {
			throw new UserException("User Details doesnot Exists");
		}
		return userDetails.getUserPassword().equals(user.getUserPassword());
	}
	

	@Override
	public boolean signOut(UserModel user) throws UserException {
		
		return true;
	}

	@Override
	public List<UserModel> getAll() {
		return userRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Override
	public UserModel getUser(String userName) throws UserException {
		if (!userRepo.existsById(userName))
			throw new UserException("No User found for the given name");
		return parser.parse(userRepo.findById(userName).get());
	}
	@Override
	public void deleteUser(String userName) {
		if(userName==null) {
			throw new UserException("User Id Cannot be Null");
		}else if(!userRepo.existsById(userName)) {
			throw new UserException("User with user name "+userName+" Does not exists");
		}
		userRepo.deleteById(userName);
	}
	
	@Override
	public UserModel updateUser(UserModel userModel) throws UserException{
		if (userModel != null) {
			if (userRepo.existsById(userModel.getUserName())) {
				throw new UserException("User with this Id doesnot exisit");
			}

			userModel = parser.parse(userRepo.save(parser.parse(userModel)));
		}

		return userModel;
	}
	
	@Override
	public UserModel findById(String userName) throws UserException {
		if(userName==null) {
			throw new UserException("User Name Cannot be Null");
		}else if(!userRepo.existsById(userName)) {
			throw new UserException("User with user Name "+userName+" Does not exists");
		}
		return parser.parse(userRepo.findById(userName).orElse(null));
	}
	
	@Override
	public boolean changePassword(ChangePassword changePassword) throws UserException {
		if(changePassword==null) {
			throw new UserException("Change details should not be null");
		}
		UserModel user=parser.parse(userRepo.findById(changePassword.getUserName()).orElse(null));
		if(user==null) {
			throw new UserException("User details Does not exists");
		}
		boolean isChanged=false;
		if(user.getUserPassword().equals(changePassword.getCurrentPassword()) && changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
			user.setUserPassword(changePassword.getConfirmPassword());
			userRepo.save(parser.parse(user));
			isChanged= true;
		}
		return isChanged;
	}
	
	@Override
	public UserModel signUp(SignUp signUp) throws UserException {
		if(signUp==null) {
			throw new UserException("SignUp details cannot be Null");
		}
		UserModel user=parser.parse(userRepo.findById(signUp.getUserName()).orElse(null));
		if(user==null) {
			throw new UserException("SignUp details Does not Exists");
		}
		if(user.getUserPassword().equals(signUp.getKey()) && signUp.getCreatePassword().equals(signUp.getConfirmPassword())) {
			user.setUserPassword(signUp.getConfirmPassword());
			user=parser.parse(userRepo.save(parser.parse(user)));
		}
		return user;
	}


	@Override
	public boolean existsById(String userName) {
			return userRepo.existsById(userName);
		
	}

	@Override
	public List<UserModel> findAll() {
		return userRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
}
