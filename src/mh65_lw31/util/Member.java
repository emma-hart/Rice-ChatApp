package mh65_lw31.util;

import java.rmi.RemoteException;
//import java.util.UUID;

import common.IMember;
import common.IChatRoom;
import common.ICmd2ModelAdapter;
import common.IRemoteConnection;
import common.message.ChatroomDataPacket;
import common.message.ChatroomDataPacketAlgo;

import provided.datapacket.IDataPacketData;

/**
 * Concrete Member class
 */
public class Member implements IMember {
	/**
	 * The API compliant ChatroomDataPacketAlg visitor installed in this ChatApp
	 */
	private ChatroomDataPacketAlgo visitor;
	/**
	 * The room this member is in
	 */
	private IChatRoom room;
	/**
	 * The member's userStub
	 */
	private IRemoteConnection userStub;
//	private transient ICmd2ModelAdapter c2mAdpt;
//	private UUID id;
//	private IMember repstub;
	
	//public int BOUND_PORT_REP = IMember.BOUND_PORT; // 2101
	
	/**
	 * Constructor, core of message handling
	 * @param _room Chat room
	 * @param _userStub Stub of the user
	 * @param _c2mAdpt Cmd2ModelAdapter
	 * @param visitor Visitor
	 */
	public Member(IChatRoom _room, IRemoteConnection _userStub, ICmd2ModelAdapter _c2mAdpt, ChatroomDataPacketAlgo visitor) {
		//this.room = _room;
		// make a deep opy of this chatroom with UUID
		room = new ChatRoom(_room.getName(), _room.getUUID());
		// add all exisiting members to this room
		for (IMember repStub: _room.getMembers()) {
			room.getMembers().add(repStub);
		}
		this.userStub = _userStub;
//		this.c2mAdpt = _c2mAdpt;
//		this.id = UUID.randomUUID();
		this.visitor = visitor;
		
//		try {
//			this.repstub = (IRepresentative) UnicastRemoteObject.exportObject(this, BOUND_PORT_REP);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/* Installing well-known msg type commands to the visitor!! */
		
		// default cmd
//		IExtVisitorCmd<R, I, P, H> defaultcmd = new IExtVisitorCmd<> () {
//			@Override
//			public <T extends IExtVisitorHost<I, ? super H>> R apply(I index, T host){
//				// TODO Auto-generated method stub
//				host.receiveMsg(IRequestInstruction);
//			}
//		}
//				IRequestInstruction();
		//ADataPacketAlgoCmd defaultcmd = null;
		//this.visitor = new DataPacketAlgo(defaultcmd);
		// cmd for IText
//		ADataPacketAlgoCmd<Integer, IText, Integer, ICmd2ModelAdapter, DataPacket<IText, IRepresentative>> textCmd 
//		= new ADataPacketAlgoCmd<>() {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 4033756108955376172L;
//
//			@Override
//			public Integer apply(IDataPacketID index, DataPacket<IText, IRepresentative> host, Integer... params) {
//				// TODO Auto-generated method stub
//				c2mAdpt.appendString(host.getData().getText());
//				//return host.getData().getText();
//				return 0;
//			}
//
//			@Override
//			public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
//				// TODO Auto-generated method stub
//				//c2mAdpt = cmd2ModelAdpt;
//			}
//			
//		};
		// default
//		UnknownMessageCmd defaultCmd = new UnknownMessageCmd(repstub);
//		defaultCmd.setCmd2ModelAdpt(this.c2mAdpt);
//		this.visitor = new DataPacketAlgo<Integer, Integer>(defaultCmd);
		
//		// text
//		TextCmd textCmd = new TextCmd(this.c2mAdpt);
//		textCmd.setCmd2ModelAdpt(this.c2mAdpt);
//		this.visitor = new ChatroomDataPacketAlgo(textCmd);
//		visitor.setCmd(ITxtData.GetID(), textCmd);
//		
		// requestInstruction
//		RequestInstructionCmd requestInstructionCmd = new RequestInstructionCmd(c2mAdpt, room, repstub);
//		requestInstructionCmd.setCmd2ModelAdpt(this.c2mAdpt);
//		visitor.setCmd(IRequestInstruction.GetID(), requestInstructionCmd);
		
//		// instruct
//		InstructCmd instructCmd = new InstructCmd(c2mAdpt, room);
//		instructCmd.setCmd2ModelAdpt(this.c2mAdpt);
//		visitor.setCmd(IInstallCmdData.GetID(), instructCmd);
		
		//cmd for getChatRooms
		//ADataPacketAlgoCmd<Integer, > getChatRoomCmd;
		
		
		// cmd for IAddRep		
//		ADataPacketAlgoCmd<Integer, IAddRep, Integer, ICmd2ModelAdapter, DataPacket<IAddRep, IRepresentative>> addRepCmd 
//		= new ADataPacketAlgoCmd<>() {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public Integer apply(IDataPacketID index, DataPacket<IAddRep, IRepresentative> host, Integer... params) {
//				room.addRep(host.getData().getRepToAdd());
//				c2mAdpt.appendString("A new user has joined!\n");
//				return 0;
//			}
//
//			@Override
//			public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
//				//c2mAdpt = cmd2ModelAdpt;
//			}
//		};
//		JoinDataCmd addRepCmd = new JoinDataCmd(c2mAdpt, room);
//		addRepCmd.setCmd2ModelAdpt(this.c2mAdpt);
//		visitor.setCmd(IAddRep.GetID(), addRepCmd);
//		
//		LeaveDataCmd removeRepCmd = new LeaveDataCmd(c2mAdpt, room);
//		removeRepCmd.setCmd2ModelAdpt(this.c2mAdpt);
//		visitor.setCmd(IRemoveRep.GetID(), removeRepCmd);
		
		/* End of Visitor Initialization */
	}
	
	@Override
	public void receiveData(ChatroomDataPacket<? extends IDataPacketData> dp) throws RemoteException {
		dp.execute(visitor);
	}

	@Override
	public String getName() throws RemoteException {
		return userStub.getName();
	}

	@Override
	public IRemoteConnection getRemoteConnection() throws RemoteException {
		return userStub;
	}

//	@Override
//	public void receiveMessage(ADataPacket D) {
//		// TODO Auto-generated method stub
////		if (D.getClass().equals(IInstruct.class)) {
////			IInstruct I = (IInstruct) D;
////			visitor.setCmd(idx, I.getCmd());
////		}
//		D.execute(visitor);
//		//System.out.println("HEloo");
//		//System.out.println(D.toString());
//		//c2mAdpt.appendString(D.toString());
//	}

//	@Override
//	public IChatRoom getRoom() {
//		return room;
//	}
//
//	@Override
//	public UUID getID() {
//		return id;
//	}

//	@Override
//	public String getUserName() throws RemoteException {
//		return userStub.getName();
//	}
	
//	public UUID getUserID() throws RemoteException {
//		return userStub.getUUID();
//	}
	
	//@Override
//	public void setRoom(IChatRoom chatroom) {
//		this.room = chatroom;
//	}

}
