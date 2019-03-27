package common.message.status;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known status error message that is sent when something goes wrong during
 * processing of a message by a visitor - maybe a null pointer exception, divide by 0, etc. 
 * 
 * Sending the error: The sender of the error should format an error text String containing
 * information about the message that failed and their name so that the receiver knows who
 * didn't properly process their message.
 * 
 * Receiving the error: The receiver of this error should display the error text String
 * inside the user's chatroom to let the user know of any malfunctions of their chatapp.
 * 
 * @author Stephanie Yang
 */
public interface IStatusProcessingError extends IStatus {
	
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(IStatusProcessingError.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
}
