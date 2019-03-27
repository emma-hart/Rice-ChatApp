package mh65_lw31.chatroom.controller;

import java.awt.Component;
import java.rmi.RemoteException;

import common.IChatRoom;
import common.IRemoteConnection;
import mh65_lw31.chatroom.model.ChatRoomModel;
import mh65_lw31.chatroom.model.IChatRoomModel2ViewAdapter;
import mh65_lw31.chatroom.model.IMini2MainAdapter;
import mh65_lw31.chatroom.view.ChatRoomView;
import mh65_lw31.chatroom.view.IChatRoomView2ModelAdapter;

/**
 * Controller of the mini MVC
 */
public class ChatRoomController {
	
	/**
	 * The chatroom model
	 */
	private ChatRoomModel roomModel;
	/**
	 * The chatroom view
	 */
	private ChatRoomView roomView;
	
	/**
	 * Constructor 
	 * @param chatroom Chat room
	 * @param userMainStub Stub of the user.
	 * @param m2MAdpt IMini2MainAdapter
	 */
	public ChatRoomController(IChatRoom chatroom, IRemoteConnection userMainStub, IMini2MainAdapter m2MAdpt) {
//		roomModel = new ChatRoomModel(chatroom, new IChatRoomModel2ViewAdapter() {
//		});
		
		roomView = new ChatRoomView(new IChatRoomView2ModelAdapter() {

//			@Override
//			public IInstruct addMessage(String msg) {
//				// TODO Auto-generated method stub
//				return null;
//			}

//			@Override
//			public IText addText(String text) {
//				return new Text(text);
//			}

			@Override
			public void sendText(String msg) {
				roomModel.sendText(msg);
				
//				// Make a DataPacket for IText
//				ITxtData ITextData = new Text(msg);
//				ChatroomDataPacket<ITxtData> dp = new ChatroomDataPacket<>(ITextData, repStub);
//				try {
//					roomModel.broadcastMessage(dp);
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			
			@Override
			public void sendImage(String path) {
				roomModel.sendImage(path);
//				knownType input = new knownType(text);
//				// Make a DataPacket for sending first known type (unknown to others)
//				ChatroomDataPacket<knownType> dp = new ChatroomDataPacket<>(input, repStub);
//				try {
//					roomModel.broadcastMessage(dp);
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}				
			}

			@Override
			public void leaveRoom() {
				// TODO Auto-generated method stub
				try {
					roomModel.leaveRoom();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Override
			public void removeRoomfromList() {
				roomModel.removeRoomfromList();
			}
			
//			@Override
//			public void sendText(String Data) {
//				// Make a DataPacket for IText
//				IText ITextData = new Helper(Data);
//				DataPacket<IText, IRepresentative> dp = new DataPacket<>(ITextData, repStub);
//				roomModel.broadcastMessage(dp);
//			}
		});
		
		roomModel = new ChatRoomModel(chatroom, m2MAdpt, userMainStub, new IChatRoomModel2ViewAdapter() {
			@Override
			public void appendString(String t) {
				//System.out.println("ChatRoomController Debug 1");
				roomView.sendMsg(t);
			}

			@Override
			public void addComponent(Component comp) {
				roomView.addComponent(comp);
			}
		});
	}
	

//	public IText helper(String data) {
//		return new IText() {
//			private static final long serialVersionUID = 2853890249825345297L;
//
//			@Override
//			public String getText() {
//				return data;
//			}
//			
//			@Override
//			public String toString() {
//				return data;
//			}
//		};
//	}
	/**
	 * Get the mini chat room model
	 * @return The mini model
	 */
	public ChatRoomModel getMiniModel() {return roomModel;}
	
	/**
	 * Get the mini chat room view
	 * @return The mini view 
	 */
	public ChatRoomView getMiniView() {return roomView;}
	
	/**
	 * Start the model and the view
	 */
	public void start() {
		roomModel.start();
		roomView.start();
	}

}
