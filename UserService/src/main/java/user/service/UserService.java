package user.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.entity.User;
import user.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}

	public User getUser(long id) throws Exception {
		return userRepo.findById(id).orElseThrow(()->new Exception("User not found ! 404L User"));
	}

	public User addUser(User user) {
		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		return userRepo.save(user);
	}

	public User getUser(String userName) {
		return userRepo.findByUserName(userName);
	}
}
