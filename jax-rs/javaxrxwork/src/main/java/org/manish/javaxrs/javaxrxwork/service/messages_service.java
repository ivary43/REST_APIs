package org.manish.javaxrs.javaxrxwork.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.manish.javaxrs.javaxrxwork.databases.DatabaseClass;
import org.manish.javaxrs.javaxrxwork.models.Message;

public class messages_service {

	private Map<Long,Message> messages = DatabaseClass.getMessages(); 
	
	public messages_service(){
		messages.put((long) 1,new Message(1,"This is x","Manish Kumar"));
		messages.put((long)2,new Message(2,"This is draxx","Manish Kumar"));
	}
	
	public List<Message> getAllMessage() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessage( int year) {
		List <Message> messageInYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()) {
			cal.setTime(message.getCreated());
			
			if(cal.get(Calendar.YEAR) == year) {
				messageInYear.add(message);
			}
		}
		return messageInYear;
	}
	
	public Message getMessage(long Id) {
		return messages.get(Id);
	}
	
	//if we want to send a custom status code if added and redirect to new handler
	public Message addMessage(Message message ) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
//	//if we want to send a custom status code if added and redirect to new handler
//	public Response addMessage(Message message) {
//		message.setId(messages.size()+1);
//		messages.put(message.getId(), message);
//		return Response.status(Status.CREATED)
//				.entity(message)
//				.build();
//	}
	
	public Message updateMessage(Message message) {
		if(message.getId() < 0 ) {
			return null;
		} else {
			messages.put(message.getId(), message);
			return message;
		}		
	}
	
	public int removeMessage(long Id) {
		messages.remove(Id);
		return 200;
	}
}