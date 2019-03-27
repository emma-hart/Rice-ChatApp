package mh65_lw31.chatroom.model;

import common.IChatRoom;

/**
 * The adapter from the mini to main adapter
 */
public interface IMini2MainAdapter {
	/**
	 * Remove the room from the main view
	 * @param room The room to remove
	 */
	public void removeRoomFromMainView(IChatRoom room);
	
	/**
	 * Add the room to the user
	 * @param room The room to add
	 */
	public void addRoom2User(IChatRoom room);
	
	/**
	 * Remove the room for the user
	 * @param room The room to remove
	 */
	public void removeRoom4User(IChatRoom room);

	/**
	 * Remove the room from the user's list of rooms
	 * @param room The room to remove
	 */
	public void removeRoomFromMainList(IChatRoom room);
}
