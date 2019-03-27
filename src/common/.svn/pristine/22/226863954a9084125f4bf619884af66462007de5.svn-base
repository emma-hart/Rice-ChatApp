package common.message;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketData;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known DataPacketData type that contains the request new command command (command that gets a command),
 * which is an ADataPacketAlgoCmd, that notifies its receiver that it needs a command for some unknown type.
 * 
 * @author Andres Salgado
 * @author Joel Webb
 */
public interface IRequestCmdData extends IDataPacketData {
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(IRequestCmdData.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
	
	/**
	 * This method returns the IDataPacketID of the unknown type that requires a command.
	 * 
	 * @return The IDataPacketID of the unknown command type.
	 */
	public  IDataPacketID getRequestedCmdType();
}