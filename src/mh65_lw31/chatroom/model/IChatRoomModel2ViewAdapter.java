package mh65_lw31.chatroom.model;

import java.awt.Component;

/**
 * The adapter from the mini model to view
 */
public interface IChatRoomModel2ViewAdapter {
	/**
	 * Add text to the view
	 * @param t Text to display
	 */
	public void appendString(String t);
	
	/**
	 * Add the GUI component 
	 * @param comp The GUI component to add
	 */
	public void addComponent(Component comp);
}
