package mh65_lw31.util;

import common.IChatRoom;

/**
 * Wrapper around the chat room
 */
public class ChatRoomWrapper {
	/**
	 * The room wrapped in
	 */
	private IChatRoom chatroom;
	
	/**
	 * Constructor
	 * @param room Chat room
	 */
	public ChatRoomWrapper(IChatRoom room) {chatroom = room;}
	
	/**
	 * Gets the chat room
	 * @return the Chat room
	 */
	public IChatRoom getRoom() {return chatroom;}
	
	@Override
	public String toString() {
		String name = "unknown user";
		try {
			name = chatroom.getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
}
