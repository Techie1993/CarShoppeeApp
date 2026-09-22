package com.example.chats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatImpl implements ChatService {
	
	@Autowired
	private ChatRepository chatrepo;

	@Override
	public ChatMessage SaveMsg(ChatMessage chats) {
		ChatMessage saved=chatrepo.save(chats);
		return saved;
	}

	@Override
	public List<ChatMessage> GetAllChats(int uid) {
		List<ChatMessage>AllChats=chatrepo.findByRegistrationUidOrderByMessageTimeAsc(uid);
		return AllChats;
	}

}
