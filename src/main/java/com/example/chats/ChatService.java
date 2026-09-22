package com.example.chats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface ChatService {

	public ChatMessage SaveMsg(ChatMessage chats);
	
	public List<ChatMessage>GetAllChats(int uid);
	
}
