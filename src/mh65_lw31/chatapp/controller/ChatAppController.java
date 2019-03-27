package mh65_lw31.chatapp.controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import common.IChatRoom;
import common.IRemoteConnection;
import mh65_lw31.chatapp.model.*;
import mh65_lw31.chatapp.view.*;
import mh65_lw31.chatroom.controller.ChatRoomController;
import mh65_lw31.chatroom.model.IMini2MainAdapter;
import mh65_lw31.chatroom.view.ChatRoomView;
import mh65_lw31.util.ChatRoomWrapper;
import mh65_lw31.util.RemoteConnectionWrapper;

/**
 * Controller for ChatApp.
 *
 */
public class ChatAppController {
	/**
	 * Chatapp model.
	 */
	private ChatAppModel  chatappmodel;
	
	/**
	 * Chatapp GUI.
	 */
	//@SuppressWarnings("rawtypes")
	private ChatAppGUI<RemoteConnectionWrapper, ChatRoomWrapper> chatappview;
	
	/**
	 * Chatroom controller.
	 */
	//private ChatRoomController miniController;

	/**
	 * Constructor for the Controller, instantiates both the model and view
	 */
	public ChatAppController() {
		chatappmodel = new ChatAppModel(new IChatAppModel2ViewAdapter() {
			@Override
			public void displayStatus(String s) {
				chatappview.displayStatus(s);
			}
			
			@Override
			public void removeRoomFromView(IChatRoom room) {
				chatappview.removeMiniView(new ChatRoomWrapper(room));
			}
			
			@Override
			public void removeAllRooms() {
				chatappview.removeAllMiniViews();
			}

			@Override
			public void addUser(IRemoteConnection userStub) {
				chatappview.addUser(new RemoteConnectionWrapper(userStub));
				
			}
			
			@Override
			public void addChatroom(IChatRoom chatroom) {
				// TODO Auto-generated method stub
				chatappview.addRoom(new ChatRoomWrapper(chatroom));
			}

			// This makeMiniMVC method in fact has a lot going on:
			// 1. m2vAdpt instantiates a mini-controller;
			// 2. mini-controller makes mini-model, mini-view, and mini-adapters;
			// 3. mini-controller installs the mini-view into the main-view;
			// 4. finally the m2vAdpt returns the resultant adapter to the mini MVC.
			@Override
			public IMain2MiniAdapter makeMiniMVC(IChatRoom room, IRemoteConnection userStub) {
				// step 1 and 2
				ChatRoomController miniController;
				miniController = new ChatRoomController(room, userStub, new IMini2MainAdapter() {

					@Override
					public void removeRoomFromMainView(IChatRoom room) {
						chatappview.removeMiniView(new ChatRoomWrapper(room));
					}

					@Override 
					public void removeRoomFromMainList(IChatRoom room) {
						chatappview.removeRoomFromList(new ChatRoomWrapper(room));
					}
					
					@Override
					public void addRoom2User(IChatRoom room) {
						chatappmodel.addRoom2User(room);
					}

					@Override
					public void removeRoom4User(IChatRoom room) {
						chatappmodel.removeRoom4User(room);
					}
				});				
				
				// install the mini-view
				ChatRoomView miniView = miniController.getMiniView();
				chatappview.installMiniView(room.getName(), miniView);
				
				// return the resultant Main2Mini Adapter
				return new IMain2MiniAdapter() {
					
					@Override
					public void appendString(String text) {
						miniView.sendMsg(text);
					}

					@Override
					public void addComponent(Supplier<Component> compFac) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public IChatRoom getMiniRoom() {
						return miniController.getMiniModel().getRoom();
					}	
				};
			}
		});
		
		chatappview = new ChatAppGUI<>(new IChatAppView2ModelAdaptor<RemoteConnectionWrapper, ChatRoomWrapper>() {
//			@Override
//			public void admin() {
//				chatappmodel.admin();
//			}
//
//			@Override
//			public void guest() {
//				chatappmodel.guest();
//			}
			
			@Override
			public void quit() {
				try {
					chatappmodel.stop();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public RemoteConnectionWrapper connectUser(String IP) throws RemoteException {
				return new RemoteConnectionWrapper(chatappmodel.connectTo(IP));
			}

			@Override
			public List<ChatRoomWrapper> getSelectedUserRooms(RemoteConnectionWrapper stub) throws RemoteException {
				List <ChatRoomWrapper> list = new ArrayList<ChatRoomWrapper>();
				stub.getUser().getChatRooms().forEach((room) -> list.add(new ChatRoomWrapper(room)));
				return list;
			}
			
//			@Override
//			public List<IChatRoom> getMyRooms() throws RemoteException {
//				return chatappmodel.getMyRooms();
//			}
			
			@Override
			public ChatRoomWrapper createRoom(String name)  {
				return new ChatRoomWrapper(chatappmodel.createChatRoom(name));
			}

			@Override
			public void joinRoom(ChatRoomWrapper roomWrapper) throws RemoteException {
				// TODO Auto-generated method stub
				chatappmodel.joinChatRoom(roomWrapper.getRoom());
			}

			@Override
			public void leaveRoom(ChatRoomWrapper roomWrapper) {
				// TODO Auto-generated method stub
				chatappmodel.leaveChatRoom(roomWrapper.getRoom());
			}
			
			@Override
			public void inviteUser(RemoteConnectionWrapper stubWrapper, ChatRoomWrapper roomWrapper) {
				chatappmodel.inviteUserToRoom(stubWrapper.getUser(), roomWrapper.getRoom());
			}
			
		});
	}
	
	/**
	 * Start the system
	 */
	public void start() {
		chatappmodel.start();
		//chatappmodel.admin();
		chatappview.start();
	}
	
	/**
	 * @param args Inputed arguments for the main method
	 * Main method for the Controller, instantiates and starts the Controller and handles exceptions
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatAppController controller = new ChatAppController();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


