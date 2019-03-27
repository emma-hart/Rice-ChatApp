package mh65_lw31.chatroom.view;


/**
 * View2ModelAdapter for the mini MVC chatroom.
 */
public interface IChatRoomView2ModelAdapter {
	//public TMessageDropListItem addMessage(String msg);
	
	//public TTextDropListItem addText(String text);

	//public void sendText(TTextDropListItem ITextData);
	//public void sendText(String ITextData);
	
	/**
	 * Leave chatroom.
	 */
	public void leaveRoom();

	/**
	 * Sends a string
	 * @param text The text to send.
	 */
	public void sendText(String text);

	/**
	 * Sends an image
	 * @param path The image to send.
	 */
	public void sendImage(String path);

	/**
	 * Remove room from list of rooms you're in.
	 */
	public void removeRoomfromList();
}
