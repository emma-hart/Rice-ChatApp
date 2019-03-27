package mh65_lw31.data;

import java.rmi.RemoteException;

import common.IChatRoom;
import common.message.AMessageCmd;
import common.message.ChatroomDataPacket;
import common.message.IJoinData;
import mh65_lw31.chatroom.model.IChatRoomModel2ViewAdapter;
import provided.datapacket.IDataPacketID;

/**
 * Join command for joining a room.
 */
public class JoinDataCmd extends AMessageCmd<IJoinData>{
	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = 3360188651121025465L;
	//private ICmd2ModelAdapter c2mAdpt;
	/**
	 * Room to join
	 */
	private IChatRoom room;
	/**
	 * Adapter from model to view of the chat room
	 */
	private IChatRoomModel2ViewAdapter _m2vAdpt;
	
	/**
	 * Constructor
	 * @param room chatroom
	 * @param m2vAdpt IChatRoomModel2ViewAdapter
	 */
	public JoinDataCmd(IChatRoom room, IChatRoomModel2ViewAdapter m2vAdpt) {
		//this.c2mAdpt = adpt;
		this.room = room;
		this._m2vAdpt = m2vAdpt;
	}
	
//	@Override
//	public Integer apply(IDataPacketID index, DataPacket<IAddRep, IRepresentative> host, Integer... params) {
//		room.addRep(host.getData().getRepToAdd());
//		c2mAdpt.appendString("A new user has joined!\n");
//		return 0;
//	}

	@Override
	public Void apply(IDataPacketID index, ChatroomDataPacket<IJoinData> host, Void... params) {
		room.getMembers().add(host.getSender());
		try {
			//System.out.println(host.getSender().getName());
			this._m2vAdpt.appendString(host.getSender().getName() + "has just joined!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		//room.sendMsgToAll(host);
		//room.addRep(host.getData()..getRepToAdd());
	}
}
