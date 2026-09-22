package com.example.chats;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatMessage,Integer> {

	
	List<ChatMessage>findByRegistrationUidOrderByMessageTimeAsc(int uid);
	
	
	
}
