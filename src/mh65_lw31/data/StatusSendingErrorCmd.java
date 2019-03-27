package mh65_lw31.data;

import java.rmi.RemoteException;

import common.IChatRoom;
import common.message.AMessageCmd;
import common.message.ChatroomDataPacket;
import common.message.status.IStatusSendingError;
import mh65_lw31.chatroom.model.IChatRoomModel2ViewAdapter;
import provided.datapacket.IDataPacketID;

/**
 * Command for status error.
 */
public class StatusSendingErrorCmd extends AMessageCmd<IStatusSendingError>{
	/**
	 * Generated ID.
	 */
	private static final long serialVersionUID = -4752472140088879738L;
	/**
	 * Chat room
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
	public StatusSendingErrorCmd(IChatRoom room, IChatRoomModel2ViewAdapter m2vAdpt) {
		//c2Madpt = adpt;
		chatroom =  room;
		this._m2vAdpt = m2vAdpt;
	}

	@Override
	public Void apply(IDataPacketID index, ChatroomDataPacket<IStatusSendingError> host, Void... params) {
		chatroom.getMembers().remove(host.getData().getMember());
		try {
			this._m2vAdpt.appendString(host.getSender().getName() + "has been removed due to a remote error!");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
};
