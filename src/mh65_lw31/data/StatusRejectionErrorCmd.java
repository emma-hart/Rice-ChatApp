package mh65_lw31.data;

import java.rmi.RemoteException;

import common.IChatRoom;
import common.message.AMessageCmd;
import common.message.ChatroomDataPacket;
import common.message.status.IStatusRejectionError;
import mh65_lw31.chatroom.model.IChatRoomModel2ViewAdapter;
import provided.datapacket.IDataPacketID;

/**
 * Command for if you receive a request to process a well known type.
 */
public class StatusRejectionErrorCmd extends AMessageCmd<IStatusRejectionError> {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -3639818792909512380L;
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
	public StatusRejectionErrorCmd(IChatRoom room, IChatRoomModel2ViewAdapter m2vAdpt) {
		chatroom =  room;
		this._m2vAdpt = m2vAdpt;
	}
	
	@Override
	public Void apply(IDataPacketID index, ChatroomDataPacket<IStatusRejectionError> host, Void... params) {
		try {
			this._m2vAdpt.appendString(host.getSender().getName() + "has sent when a request message for a well known message!");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
