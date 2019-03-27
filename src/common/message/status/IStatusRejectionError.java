package common.message.status;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known status error message that is sent when a request message
 * is received asking for a well-known message type.
 * 
 * Sending the error: The sender of the error should format an error text String containing
 * information about the well-known message and the sender name.
 * 
 * Receiving the error: The receiver of this error should display the error text String
 * inside the user's chatroom to let the user know of any malfunctions of their chatapp.
 * 
 * @author Stephanie Yang
 */
public interface IStatusRejectionError extends IStatus {
	
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(IStatusRejectionError.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
}
