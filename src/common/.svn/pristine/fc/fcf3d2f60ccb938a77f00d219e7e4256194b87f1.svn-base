package common.message;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketData;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known DataPacketData type that contains the install new command command (command that has a new a command),
 * which is an ADataPacketAlgoCmd, that notifies its receiver that it has a command for an originally unknown type for the sender.
 * 
 * @author Andres Salgado
 * @author Joel Webb
 */
public interface IInstallCmdData extends IDataPacketData {
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(IInstallCmdData.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
	
	/**
	 * This method returns the new command of the unknown type that requires a command.
	 * @return A new AMessageCmd for the previously unknown type.
	 */
	public AMessageCmd<?> getCmdToInstall();
	
	/**
	 * This method returns the IDataPacketID of the command type to be installed.
	 * @return the IDataPacketID of the command type to be installed.
	 */
	public IDataPacketID getInstallCmdType();

}