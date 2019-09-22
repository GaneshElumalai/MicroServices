package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import user.entity.User;
import user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
//	@GetMapping("/{userId}")
//	public User getUser(@PathVariable long userId) throws Exception {
//		return userService.getUser(userId);
//	}
	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName) throws Exception {
		return userService.getUser(userName);
	}
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
