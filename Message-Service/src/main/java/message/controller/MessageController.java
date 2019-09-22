package message.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import message.entity.Message;
import message.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@GetMapping("/messages/{id}")
	public Message getMessage(@PathVariable(value="id") long msgId){
		return messageService.getMessage(msgId);
	}
	
	@GetMapping("/messages")
	public List<Message> getMessages() throws Exception{
		return messageService.getMessages();
	}
	
	@PostMapping("/users/{userId}/messages")
	public Message addMessage(@PathVariable("userId") long userId,@RequestBody Message msg){
		return messageService.addMessage(userId,msg);
	}
	
	@GetMapping("/users/{userId}/messages")
	public List<Message> getUserMessages(@PathVariable("userId") long userId){
		return messageService.getUserMessages(userId);
	}
	
	@DeleteMapping("/messages/{msgId}")
	public void deleteMessage(@PathVariable("msgId") long msgId){
		messageService.deleteMessage(msgId);
	}
}
