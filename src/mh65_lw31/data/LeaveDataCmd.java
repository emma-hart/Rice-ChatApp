package mh65_lw31.data;

import java.rmi.RemoteException;

import common.IChatRoom;
import common.message.AMessageCmd;
import common.message.ChatroomDataPacket;
import common.message.ILeaveData;
import mh65_lw31.chatroom.model.IChatRoomModel2ViewAdapter;

import provided.datapacket.IDataPacketID;

/**
 * @author Rocmeister
 *
 */
public class LeaveDataCmd extends AMessageCmd<ILeaveData> {
	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -5482197100459678016L;
	//implements IExtVisitorCmd<R, IDataPacketID, P, ADataPacket>{
	//ICmd2ModelAdapter c2Madpt;
	/**
	 * Chatroom 
	 */
	IChatRoom chatroom;
	/**
	 * Adapter from model to view of the chat room
	 */
	private IChatRoomModel2ViewAdapter _m2vAdpt;
	
	/**
	 * Constructor
	 * @param room Room to leave
	 * @param m2vAdpt Model2ViewAdapter
	 */
	public LeaveDataCmd(IChatRoom room, IChatRoomModel2ViewAdapter m2vAdpt) {
		//c2Madpt = adpt;
		chatroom =  room;
		this._m2vAdpt = m2vAdpt;
	}

//	@Override
//	public Integer apply(IDataPacketID index, DataPacket<IRemoveRep, IRepresentative> host, Integer... params) {
//		// TODO Auto-generated method stub
//		c2Madpt.appendString("A user has left!\n");
//		chatroom.deleteRep(host.getData().getRepToRemove());
//		return 0;
//	}

	@Override
	public Void apply(IDataPacketID index, ChatroomDataPacket<ILeaveData> host, Void... params) {
		chatroom.getMembers().remove(host.getSender());
		try {
			this._m2vAdpt.appendString(host.getSender().getName() + "has just left!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
