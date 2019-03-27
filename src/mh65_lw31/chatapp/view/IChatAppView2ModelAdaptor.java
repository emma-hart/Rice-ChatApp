package mh65_lw31.chatapp.view;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Adapter from the main view to model
 * @param <TUserDropListItem> User
 * @param <TRoomDropListItem> Chat room
 */
public interface IChatAppView2ModelAdaptor<TUserDropListItem, TRoomDropListItem> {
//	public void admin();
//	
//	public void guest();
	
	/**
	 * Quits the application
	 */
	public void quit();

	/**
	 * Connects user to remote user
	 * @param IP IP address of remote user
	 * @return Connected user 
	 * @throws RemoteException throws exception when connecting user
	 */
	public TUserDropListItem connectUser(String IP) throws RemoteException;
	
	/**
	 * Gets the rooms that a connected user is in
	 * @param stub The connected user
	 * @return The list of rooms of the connected user
	 * @throws RemoteException throws exception when trying to get user rooms 
	 */
	public List<TRoomDropListItem> getSelectedUserRooms(TUserDropListItem stub) throws RemoteException;

//	public List<TRoomDropListItem> getMyRooms() throws RemoteException;

//	public void addUser();
//	
//	public void addUserChatRoom();
	
	/**
	 * Makes a new room
	 * @param name The name of the new chat room
	 * @return A new chatroom
	 */
	public TRoomDropListItem createRoom(String name);
	
	/**
	 * Join an existing room 
	 * @param room The room to join
	 * @throws RemoteException throws exception when joining room 
	 */
	public void joinRoom(TRoomDropListItem room) throws RemoteException;
	
	/**
	 * Leave a room you are in
	 * @param room The room to leave
	 */
	public void leaveRoom(TRoomDropListItem room);

	/**
	 * Invite another user to a room you're in
	 * @param connectedUser The other user
	 * @param yourRoom Your room you want them to join
	 */
	public void inviteUser(TUserDropListItem connectedUser, TRoomDropListItem yourRoom);


}
