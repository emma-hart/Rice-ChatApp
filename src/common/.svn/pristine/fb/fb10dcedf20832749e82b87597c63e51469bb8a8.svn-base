package common.message;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketData;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known DataPacketData type that contains the join chatroom command, which
 * is an ADataPacketAlgoCmd, that notifies its receiver that it wants to join a chatroom.
 * 
 * @author Andres Salgado
 * @author Joel Webb
 */
public interface IJoinData extends IDataPacketData {
	
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(IJoinData.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
	
	/**
	 * A singleton IJoinData. The data of every IJoinData can be empty because the
	 * message is being sent from the IMember stub that wants to be added to the
	 * chatroom.
	 */
	public static final IJoinData SINGLETON = new IJoinData() {

		/**
		 * A generated UID for this class.
		 */
		private static final long serialVersionUID = 1384762512622600282L;};
	
}
