package reaction.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import message.entity.Message;
import message.repo.MessageRepo;
import reaction.entity.Reaction;
import reaction.entity.ReactionType;
import reaction.repo.ReactionRepo;
import user.entity.User;
import user.repo.UserRepo;

@Service
public class ReactionService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private ReactionRepo reactionRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public Message react(long userId,long msgId,ReactionType msgReaction) {
		Message msg= messageRepo.findById(msgId).get();
		User reactedUser= userRepo.findById(userId).get();
		Reaction reaction = new Reaction(reactedUser,msgReaction,new Date(),msg);
		reactionRepo.save(reaction);
		return msg;
	}

	public List<Reaction> getReactionForMessage(long msgId) {
		return reactionRepo.findByMessageId(msgId);
	}
	
	public Message updateReaction(long userId,long msgId,ReactionType msgReaction) {
		Message msg= messageRepo.findById(msgId).get();
		User reactedUser= userRepo.findById(userId).get();
		Reaction reaction=reactionRepo.findByMessageIdAndUserId(msg.getId(),reactedUser.getId());
		reaction.setReactionType(msgReaction);
		reactionRepo.save(reaction);
//		msg.setReactions(reactions);
		return msg;
	}
	
}
