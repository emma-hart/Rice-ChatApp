package mh65_lw31.chatapp.model;

import common.IChatRoom;
import common.IRemoteConnection;

/**
 * Adapter for the main model to view
 */
public interface IChatAppModel2ViewAdapter {
	
	/**
	 * Shows the status of the application
	 * @param s The text to display in the status
	 */
	public void displayStatus(String s);
	
	//public void displayMessage(String s);
	
	/**
	 * Factory Method for making a miniMVC
	 * @param room Chat room
	 * @param user The user 
	 * @return a Main2Mini Adapter that allows IRep to install well known commands
	 */
	public IMain2MiniAdapter makeMiniMVC(IChatRoom room, IRemoteConnection user);
	
	/**
	 * Removes the chat room from the view
	 * @param room The room to remove
	 */
	public void removeRoomFromView(IChatRoom room);
	
	/**
	 * Deletes all of the rooms from view for quitting.
	 */
	public void removeAllRooms();
	
	/**
	 * Adds user to room
	 * @param userStub The stub of the user
	 */
	public void addUser(IRemoteConnection userStub);
	
	/**
	 * Add chatroom
	 * @param chatroom Chat room to add
	 */
	public void addChatroom(IChatRoom chatroom);
}
