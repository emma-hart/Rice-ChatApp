package mh65_lw31.data;

import java.rmi.RemoteException;

import common.message.AMessageCmd;
import common.message.ChatroomDataPacket;
import common.message.ITxtData;
import mh65_lw31.chatroom.model.IChatRoomModel2ViewAdapter;
import provided.datapacket.IDataPacketID;

/**
 * Command for Text Data
 *
 */
public class TextDataCmd extends AMessageCmd<ITxtData>{
	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = 2958039980958378888L;
	/**
	 * Adapter from model to view of the chat room
	 */
	private IChatRoomModel2ViewAdapter _m2vAdpt;
	
	/**
	 * Constructor 
	 * @param m2vAdpt model to view adapter
	 */
	public TextDataCmd(IChatRoomModel2ViewAdapter m2vAdpt) {
		this._m2vAdpt = m2vAdpt;
	}
	
//	@Override
//	public Integer apply(IDataPacketID index, DataPacket<IText, IRepresentative> host, Integer... params) {
//		// TODO Auto-generated method stub
//		c2mAdpt.appendString(host.getData().getText());
//		//return host.getData().getText();
//		return 0;
//	}
	
	@Override
	public Void apply(IDataPacketID index, ChatroomDataPacket<ITxtData> host, Void... params) {
		try {
			this._m2vAdpt.appendString(host.getSender().getName()+ ": " + host.getData().getTxt());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}

}