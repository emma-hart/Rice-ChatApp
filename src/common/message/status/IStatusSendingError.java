package common.message.status;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketID;
import common.IMember;

/**
 * This is the well-known status error message that is sent when a Remote Exception occurs
 * while trying to send data to an IMember. This error results because that member of the chatroom
 * has left without being properly disconnected.
 * 
 * Sending the message: It is strongly recommended to first remove the member who is causing the Remote
 * Exception from your local instance of members in the chatroom. Then you should send the IStatusError
 * to all remaining members of the chatroom.
 * 
 * Receiving the message: Remove the specified user from the chatroom.
 * 
 * @author Stephanie Yang
 */
public interface IStatusSendingError extends IStatus {
	
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(IStatusSendingError.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
	
	/**
	 * @return the IMember that this IStatusSendingError holds (the one that caused a Remote Exception).
	 */
	public IMember getMember();
	
}

