package mh65_lw31.data;

import java.rmi.RemoteException;

import common.IChatRoom;
import common.message.AMessageCmd;
import common.message.ChatroomDataPacket;
import common.message.status.IStatusProcessingError;
import mh65_lw31.chatroom.model.IChatRoomModel2ViewAdapter;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known status error message cmd that is sent when something goes wrong during
 * processing of a message by a visitor.
 */
public class StatusProcessingErrorCmd extends AMessageCmd<IStatusProcessingError>{

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -134359298980886120L;
	/**
	 * Chatroom
	 */
	IChatRoom chatroom;
	/**
	 * Adapter from model to view of the chat room
	 */
	private IChatRoomModel2ViewAdapter _m2vAdpt;
	
	/**
	 * Constructor.
	 * @param room Local chatroom
	 * @param m2vAdpt Model2ViewAdapter
	 */
	public StatusProcessingErrorCmd(IChatRoom room, IChatRoomModel2ViewAdapter m2vAdpt) {
		chatroom =  room;
		this._m2vAdpt = m2vAdpt;
	}
	
	@Override
	public Void apply(IDataPacketID index, ChatroomDataPacket<IStatusProcessingError> host, Void... params) {
		try {
			this._m2vAdpt.appendString(host.getSender().getName() + "cannot process this message: " + index.toString());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
