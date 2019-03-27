package common.message;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketData;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known DataPacketData type that contains the send text chatroom command, which
 * is an ADataPacketAlgoCmd, that sends a text message to its receiver.
 * 
 * @author Joel Webb
 * @author Andres Salgado
 */
public interface ITxtData extends IDataPacketData {
	
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(ITxtData.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
	
	/**
	 * @return the String that this TxtData holds.
	 */
	public String getTxt();
	
}
