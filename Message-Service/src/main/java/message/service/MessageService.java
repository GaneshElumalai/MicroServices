package message.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import message.entity.Message;
import message.repo.MessageRepo;
import user.entity.User;
import user.repo.UserRepo;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Message getMessage(long id){
		Message requestedMessage=messageRepo.findById(id).filter(msg->msg.getDeleted()=='N').get();
		User msgUser= restTemplate.getForObject("http://user-service/user-service/users/"+requestedMessage.getAuthor(), User.class);
		requestedMessage.setUser(msgUser);
		return requestedMessage;
	}

	public List<Message> getMessages() {
		return messageRepo.findAll().stream().filter(msg->msg.getDeleted()=='N').collect(Collectors.toList());
	}

	public Message addMessage(long userId,Message msg) {
		msg.setCreated_date(new Date());
		msg.setUpdated_date(new Date());
		msg.setDeleted('N');
		User usr = userRepo.findById(userId).get();
		msg.setUser(usr);
		messageRepo.save(msg);
		return msg;
	}

	public List<Message> getUserMessages(long userId) {
		return messageRepo.findByUserId(userId).stream().filter(msg->msg.getDeleted()=='N').collect(Collectors.toList());
	}
	
	public void deleteMessage(long msgId) {
//		messageRepo.deleteById(msgId);
		Message msg = messageRepo.findById(msgId).get();
		msg.setDeleted('Y');
		messageRepo.save(msg);
	}
}
