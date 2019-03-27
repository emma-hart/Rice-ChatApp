package common;

import java.awt.Component;
import java.util.function.Supplier;
import provided.datapacket.IDataPacketData;

/**
 * This is the adapter that must be set by the well-known InstallNewCommandCmd to enable some incoming
 * ICmdData to communicate with the local system of the receiver. It is up to the user of this interface
 * to define how much access to the "local system" the command has.
 * 
 * @author Andres Salgado
 * @author Joel Webb
 */
public interface ICmd2ModelAdapter {
	/**
	 * This method ensures that the new command has a way to display its output on the local
	 * system. 
	 * 
	 * @param compFac - The component factory that commands passes to the local system, to be
	 *      			displayed however the local system chooses.
	 */
	public void addComponentFactory(Supplier<Component> compFac);
	
	/**
	 * Gets the name of the local IMember associated with the current chatroom.
	 * Returns the same value that the IMember.getName() returns for the local IMember RMI server object 
	 * associated with this chatroom.
	 * @return The username of this IMember.
	 */
	public String getLocalName();
	
	/**
	 * Sends the message to the current chatroom. This method must be non-blocking, i.e. the sending of the message must take 
	 * place on a different thread than the calling thread. 
	 * @param msg to be sent
	 */
	public void sendMessage(IDataPacketData msg);
	
	/**
	 * Sends the message to the specified member. This method must be non-blocking, i.e. the 
	 * sending of the message must take place on a different thread than the calling thread.
	 * @param msg to be sent
	 * @param member to be sent to
	 */
	public void sendMessageTo(IDataPacketData msg, IMember member);
}
