package mh65_lw31.util;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import common.IChatRoom;
import common.IMember;
import common.message.ChatroomDataPacket;
import common.message.status.IStatusSendingError;
import mh65_lw31.data.StatusSendingError;
import provided.datapacket.IDataPacketData;

/**
 * Chatroom
 */
public class ChatRoom implements IChatRoom {
	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -1781552770450864113L;
	/**
	 * Room's name
	 */
	private String name;
	/**
	 * Room's unique ID
	 */
	private UUID ID;
	/**
	 * List of members in this room
	 */
	private List<IMember> reps;
	
	/**
	 * Constructor
	 * @param roomname Name of the room
	 */
	public ChatRoom(String roomname) {
		this(roomname, UUID.randomUUID());
	}
	
	/**
	 * Constructor
	 * @param roomname Name of the room
	 * @param id ID of the room
	 */
	public ChatRoom(String roomname, UUID id) {
		this.name = roomname;
		this.ID = id;
		this.reps = new ArrayList<>();
	}
	
	@Override
	public UUID getUUID() {
		return ID;
	}

	@Override
	public void sendMsgToAll(ChatroomDataPacket<? extends IDataPacketData> dp) {
		ArrayList<IMember> repClone = new ArrayList<>();
		for (IMember member : reps) repClone.add(member);
		// spawn a new thread to handle the actual transmission, thus freeing
		// this thread to return.
		(new Thread(() -> {
				// Send the data packet to the chat room
				for (IMember rep : repClone) {
				try {
					//System.out.println("Hello");
					//System.out.println("ChatRoom has: " + reps.size() + "reps, including " + rep.getUserName());
					//rep.toString();
					rep.receiveData(dp);
					System.out.println("ChatRoom debug 2");
				} catch (RemoteException e) {
					//System.out.println("a bug?");
					// remove mem from your local chatroom copy
					reps.remove(rep);
					
					// send IStatusError to all other reps
					StatusSendingError data = new StatusSendingError(rep);
					ChatroomDataPacket<IStatusSendingError> statusErrorDP = new ChatroomDataPacket<>(data, rep);
					this.sendMsgToAll(statusErrorDP);
					
					System.out.println("ChatRoom Debug: broadcast failed."+ e.getCause());
					e.printStackTrace();
				}
		}	
				// process the returned value...
			})).start(); // start the new thread
//		(new Thread() {
//		      public void run() {
//		        super.run();
//		        repClone.iterator().forEachRemaining((r) -> {
//		          try {
//		            r.receiveData(dp);
//		          } catch (RemoteException e) {
//						e.printStackTrace();
//		          }
//		        });
//		      }
//		    }).start();

//		System.out.println("ChatRoom has: " + reps.size() + "reps");
//		for (IMember rep : repClone) {
//			try {
//				//System.out.println("Hello");
//				//System.out.println("ChatRoom has: " + reps.size() + "reps, including " + rep.getUserName());
//				//rep.toString();
//				rep.receiveData(dp);
//				System.out.println("ChatRoom debug 2");
//			} catch (RemoteException e) {
//				//System.out.println("a bug?");
//				// remove mem from your local chatroom copy
//				reps.remove(rep);
//				
//				// send IStatusError to all other reps
//				StatusSendingError data = new StatusSendingError(rep);
//				ChatroomDataPacket<IStatusSendingError> statusErrorDP = new ChatroomDataPacket<>(data, rep);
//				this.sendMsgToAll(statusErrorDP);
//				
//				System.out.println("ChatRoom Debug: broadcast failed."+ e.getCause());
//				e.printStackTrace();
//			}
//		}	
	}

	@Override
	public List<IMember> getMembers() {
		return reps;
	}
	
	@Override
	public String getName() {
		return name;
	}

//	@Override
//	public void addRep(IMember newRep) {
//		reps.add(newRep);
//	}
//
//	@Override
//	public Set<IMember> getRepresentatives() {
//		return reps;
//	}
//
//	public UUID getID() {
//		return ID;
//	}
//
//	@Override
//	public void broadcast(ADataPacket data) {
////		System.out.println(data + "\n");
//		for (IMember rep:reps) {
//			try {
//				//System.out.println("Hello");
//				//System.out.println("ChatRoom has: " + reps.size() + "reps, including " + rep.getUserName());
//				System.out.println("ChatRoom has: " + reps.size() + "reps");
//				//rep.toString();
//				rep.receiveMessage(data);
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				System.out.println("ChatRoom Debug: boradcast failed."+ e.getCause());
//				e.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public void deleteRep(IMember repToDelete) {
//		reps.remove(repToDelete);
//	}
//	
	@Override
	public String toString() {
		return name;
	}

//	@Override
//	public boolean isVisible() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
