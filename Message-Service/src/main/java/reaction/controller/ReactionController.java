package reaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import message.entity.Message;
import reaction.entity.Reaction;
import reaction.entity.ReactionType;
import reaction.service.ReactionService;

@RestController
public class ReactionController {
	
	@Autowired
	private ReactionService reactionService;
	
	@PostMapping("/users/{userId}/messages/{msgId}/reactions")
	public Message react(@PathVariable("userId") long userId,@PathVariable("msgId") long msgId,@RequestParam ReactionType reaction) {
		return reactionService.react(userId, msgId, reaction);
	}
	
	@GetMapping("/messages/{msgId}/reactions")
	public List<Reaction> getReactions(@PathVariable("msgId")long msgId){
		return reactionService.getReactionForMessage(msgId);
	}
	
	@PutMapping("/users/{userId}/messages/{msgId}/reactions")
	public Message updateReactionForUserMessage(@PathVariable("userId") long userId,@PathVariable("msgId") long msgId,@RequestParam ReactionType reaction){
		return reactionService.updateReaction(userId, msgId, reaction);
	}
}
