package common.message;

import common.IMember;
import provided.datapacket.DataPacket;
import provided.datapacket.IDataPacketData;

/**
 * These are the type-narrowed data packets that are sent as messages between chat apps. More specifically, this is the type
 * that should be used when messaging through IMember stubs.
 * 
 * @author Joel Webb - jtw5
 * @author Andres Salgado - as100
 * 
 * @param <T> The type of data the data packet will contain.
 */
public class ChatroomDataPacket<T extends IDataPacketData> extends DataPacket<T, IMember> {

	/**
	 * The unique UID of the class
	 */
	private static final long serialVersionUID = -972629542470078585L;
	
	/**
	 * The constructor for the ChatroomDataPacket.
	 * 
	 * @param data the data that the class will contain. 
	 * @param sender the stub of the IMember that is sending the data
	 */
	public ChatroomDataPacket(T data, IMember sender) {
		super(data, sender);
	}
	

}
