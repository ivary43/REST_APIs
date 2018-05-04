package org.manish.javaxrs.javaxrxwork.databases;

import java.util.HashMap;
import java.util.Map;

import org.manish.javaxrs.javaxrxwork.models.Profile;
import org.manish.javaxrs.javaxrxwork.models.Message;

public class DatabaseClass {

	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<Long,Profile> profiles = new HashMap<>();
	
	public static Map<Long,Message> getMessages() {
		return messages;
	}

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
