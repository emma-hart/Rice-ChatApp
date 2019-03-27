package mh65_lw31.chatapp.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;

import mh65_lw31.chatroom.view.ChatRoomView;
import mh65_lw31.util.ChatRoomWrapper;
import mh65_lw31.util.RemoteConnectionWrapper;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

/**
 * ChatApp view.
 * @param <TUserDropListItem> User
 * @param <TRoomDropListItem> Chatroom
 */
public class ChatAppGUI<TUserDropListItem, TRoomDropListItem> extends JFrame {
	
	/* Start of GUI components definitions */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1988886322781805412L;
	
//	// main panels
//	private JPanel contentPane;
//	private final JPanel controlPane = new JPanel();
//	private final JScrollPane displayPane = new JScrollPane();
//	
//	// connect to remote ChatApp components
//	private final JPanel pnlConnection = new JPanel();
//	private final JTextField txtHostIP = new JTextField();
//	private final JButton btnConnect = new JButton("Connect");
//	
//	// join chatroom components
//	private final JPanel pnlJoin = new JPanel();
//	private final JTextField txtRoomID = new JTextField();
//	private final JButton btnJoin = new JButton("Join");
//	
//	// display panel
//	private final JPanel pnlMessage = new JPanel();
	
	/**
	 * The view to model 
	 */
	private transient IChatAppView2ModelAdaptor<TUserDropListItem, TRoomDropListItem> _v2mAdpt;
	/**
	 * The content panel
	 */
	private final JPanel contentPane = new JPanel();
	/**
	 * The control panel
	 */
	private final JPanel controlPane = new JPanel();
	/**
	 * The display panel
	 */
	private final JPanel displayPane = new JPanel();
	
	/* Log in and Quit panel */
    /**
     * The quit panel
     */
    private final JPanel panelQuit = new JPanel();
	/**
	 * The quit button
	 */
//    private final JButton btnAdmin = new JButton("Admin");
//    private final JButton btnGuest = new JButton("Guest");
	private final JButton btnQuit = new JButton("Quit");
	
	/* Remote User panel */
	/**
	 * Connection sub-panel
	 */
	private final JPanel panelConnection = new JPanel();
	/**
	 * IP address text-field
	 */
	private final JTextField textFieldHostIP = new JTextField();
	/**
	 * Connect to user button
	 */
	private final JButton btnConnect = new JButton("Connect");
	/**
	 * Connection label
	 */
	private final JLabel lblRemoteUser = new JLabel("Remote User");
	
	/* Chatroom panel */
	/**
	 * Chatroom sub-panel
	 */
	private final JPanel panelChatRoom = new JPanel();
	/**
	 * Room name text-field
	 */
	private final JTextField textFieldRoomID = new JTextField();
	/**
	 * Droplist for the rooms a connectd user has
	 */
	private final JComboBox<TRoomDropListItem> dropListRoom = new JComboBox<>();
	/**
	 * Droplist for connected users
	 */
	private final JComboBox<TUserDropListItem> dropListConnectedUsers = new JComboBox<>();
	/**
	 * Droplist for rooms this user is in
	 */
	private final JComboBox<TRoomDropListItem> dropListCurChatrooms = new JComboBox<>();
	/**
	 * Button for creating a new chatroom
	 */
	private final JButton btnCreate = new JButton("Create");
	/**
	 * Button for joining a new chatroom
	 */
	private final JButton btnJoin = new JButton("Join");
//	private final JButton btnLeave = new JButton("Leave");
	/**
	 * Label for currently in rooms
	 */
	private final JLabel lblChatRoom = new JLabel("Your Rooms");
	
	/* User room panel */
	/**
	 * Sub-panel for user rooms
	 */
	private final JPanel panelUserRoom = new JPanel();

	/* Chatroom tabs */
	/**
	 * Tabbed panel for chatrooms mini-MVCs
	 */
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	//private final JPanel panel_1 = new JPanel();
	
	/* Status panel */
	/**
	 * Status scroll panel
	 */
	private final JScrollPane panelStatus = new JScrollPane();
	/**
	 * Status panel
	 */
	private final JPanel statusPane = new JPanel();
	/**
	 * Text area for system status
	 */
	private final JTextArea textAreaStatus = new JTextArea(10, 30);
	

	/**
	 * Label for connected users
	 */
	private final JLabel lblConnectedUsers = new JLabel("Connected Users");

	/**
	 * Label for the rooms of connected users
	 */
	private final JLabel lblUsersRooms = new JLabel("User's Rooms");

	/**
	 * Button to invite other users
	 */
	private final JButton btnInvite = new JButton("Invite");

	/**
	 * Label for creating a room
	 */
	private final JLabel lblCreateRoom = new JLabel("Create Room");

	/**
	 * Blank label for visual purposes
	 */
	private final JLabel label = new JLabel("");
	
	/* End of GUI components definitions */
	
	/**
	 * Set of rooms this user is in
	 */
	private Set<TRoomDropListItem> rooms = new HashSet<>();
	/**
	 * Set of users this user is connected to
	 */
	private Set<TUserDropListItem> users = new HashSet<>();
	
	/**
	 * Constructor
	 * @param iChatAppView2ModelAdaptor View2ModelAdapter
	 */
	public ChatAppGUI(IChatAppView2ModelAdaptor<TUserDropListItem, TRoomDropListItem> iChatAppView2ModelAdaptor) {
		this._v2mAdpt = iChatAppView2ModelAdaptor;
		initGUI();
	}
	
	/**
	 * Starts the already initialized frame, making it 
	 * visible and ready to interact with the user. 
	 */
	public void start() {
		setVisible(true);
	}

	/**
	 * Close the window
	 */
	public void stop() {
		setVisible(false);

	}
	
	/**
	 * GUI initialization
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		lblRemoteUser.setLabelFor(panelConnection);
//		txtHostIP.setToolTipText("The IP address of the host");
//		txtHostIP.setText("10.126.178.72");
//		txtHostIP.setColumns(10);
//		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//getContentPane().add(panel, BorderLayout.NORTH);
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setBounds(150, 150, 150, 150);
	    contentPane.setLayout(new BorderLayout(0, 0));
	    setContentPane(contentPane);
	    
	    contentPane.add(controlPane, BorderLayout.NORTH);
	    contentPane.add(displayPane, BorderLayout.CENTER);
		controlPane.setLayout(new GridLayout(0, 4, 0, 0));
		controlPane.add(panelQuit);
		panelQuit.setLayout(new GridLayout(3, 1));
		controlPane.add(panelQuit);
		panelQuit.add(label);
		//		panelQuit.add(btnAdmin);
		//		btnAdmin.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				_v2mAdpt.admin();
		//			}
		//		});
		//		panelQuit.add(btnGuest);
		//		btnGuest.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				_v2mAdpt.guest();
		//			}
		//		});
			    btnQuit.setToolTipText("Quit entire chatapp.");
			    panelQuit.add(btnQuit);
			    btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.quit();
			}
		});
		controlPane.add(panelConnection);
		panelConnection.setLayout(new BorderLayout(0, 0));
		panelConnection.add(lblRemoteUser, BorderLayout.NORTH);
		textFieldHostIP.setText("10.126.178.72");
		textFieldHostIP.setToolTipText("IP Address of a Remote User.");
		textFieldHostIP.setColumns(10);	
		panelConnection.add(textFieldHostIP, BorderLayout.CENTER);
		btnConnect.setToolTipText("Connect to remote user.");
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TUserDropListItem userStub;
				try {
					//System.err.println("asd");
					userStub = _v2mAdpt.connectUser(textFieldHostIP.getText());
					// add other user to the droplist1
					if (!isInUsers(userStub)) {
						dropListConnectedUsers.addItem(userStub);
						users.add(userStub);
					}
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		panelConnection.add(btnConnect, BorderLayout.SOUTH);
		
		/* User room Panel */
		controlPane.add(panelUserRoom);
		panelUserRoom.add(lblConnectedUsers);
		
		panelUserRoom.add(lblUsersRooms);
		panelUserRoom.add(dropListConnectedUsers);
		dropListConnectedUsers.setToolTipText("List of users you are currently connected to.");
		
		dropListConnectedUsers.addActionListener (new ActionListener () {
		    @SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				List<TRoomDropListItem> otherRooms;
				try {
					otherRooms = _v2mAdpt.getSelectedUserRooms((TUserDropListItem) dropListConnectedUsers.getSelectedItem());
					// add other user to the droplist1
					// clear this list
					dropListRoom.removeAllItems();
					
					// add other user's rooms to droplist2
					for (TRoomDropListItem room : otherRooms) {
						dropListRoom.addItem(room);
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} 
		    }
		});
		panelUserRoom.add(dropListRoom);
		
		dropListRoom.setToolTipText("List of rooms belonging to the connected user.");
		panelUserRoom.setLayout(new GridLayout(3, 3));
		panelUserRoom.add(btnInvite);
		btnInvite.setToolTipText("Invite a user to a room.");
		btnInvite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_v2mAdpt.inviteUser(dropListConnectedUsers.getItemAt(dropListConnectedUsers.getSelectedIndex()), dropListCurChatrooms.getItemAt(dropListCurChatrooms.getSelectedIndex()));
			}
		});
		
		panelUserRoom.add(btnJoin);
		btnJoin.setToolTipText("Join an existing chatroom.");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//TODO
					_v2mAdpt.joinRoom(dropListRoom.getItemAt(dropListRoom.getSelectedIndex()));
					//dropListCurChatrooms.addItem(dropListRoom.getItemAt(dropListRoom.getSelectedIndex()));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		/* ChatRoom Panel */
		controlPane.add(panelChatRoom);
		panelChatRoom.setLayout(new GridLayout(3, 2));
		
		panelChatRoom.add(lblCreateRoom);
		lblChatRoom.setLabelFor(panelChatRoom);
		panelChatRoom.add(lblChatRoom);
		
		panelChatRoom.add(textFieldRoomID);
		//		panelChatRoom.add(btnLeave);
				
		textFieldRoomID.setColumns(10);
		dropListCurChatrooms.setToolTipText("Chatrooms you are in.");
		panelChatRoom.add(dropListCurChatrooms);
		panelChatRoom.add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TRoomDropListItem newRoom = _v2mAdpt.createRoom(textFieldRoomID.getText());
				//dropListRoom.addItem(newRoom);
				dropListCurChatrooms.addItem(newRoom);
			}
		});
		btnCreate.setToolTipText("Create a chatroom.");
		
//		btnLeave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				_v2mAdpt.leaveRoom(dropListRoom.getItemAt(dropListRoom.getSelectedIndex()));
//			}
//		});
//		btnLeave.setToolTipText("Leave an existing chatroom.");

	
		/* Chat Room Panel*/
		tabbedPane.setToolTipText("Chatroom.");
		displayPane.add(tabbedPane);
		//tabbedPane.addTab("New tab", null, panel_1, null);
		
		/* Status panel*/
		panelStatus.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelStatus.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		displayPane.add(panelStatus);
		panelStatus.add(statusPane);
		statusPane.add(textAreaStatus);
		textAreaStatus.setToolTipText("Info about chatroom/connections/etc.");
//		panelStatus.setPreferredSize(new Dimension(10,10));
//		JLabel labelStatus = new JLabel("System Info");
//		panelStatus.add(labelStatus);
		panelStatus.setAutoscrolls(true);
		panelStatus.setViewportView(textAreaStatus);
		//panelStatus.setViewportView(statusPane);
	}
	
	/**
	 * Displays status messages
	 * @param text Text to show
	 */
	public void displayStatus(String text) {
		textAreaStatus.append(text);
	}	

	/**
	 * Add a chatroom tab
	 * @param roomName Name of the chatroom
	 * @param miniView View of the mini MVC
	 */
	public void installMiniView(String roomName, ChatRoomView miniView) {
		tabbedPane.addTab(roomName, miniView);
	}
	
	/**
	 * Remove the tab of the room
	 * @param room Room to remove
	 */
	public void removeMiniView(TRoomDropListItem room) {
		tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
		//rooms.remove(room);
	}
	
	/**
	 * Remove all tabs of the rooms you are in
	 */
	public void removeAllMiniViews() {
		tabbedPane.removeAll();
	}
	
	/**
	 * Add the user to list of connected users
	 * @param userStub The user to add
	 */
	public void addUser(TUserDropListItem userStub) {
		dropListConnectedUsers.addItem(userStub);
	}
	
	/**
	 * Add room to list of rooms
	 * @param room Room to add
	 */
	public void addRoom(TRoomDropListItem room) {
		if (!isInRooms(room)) {
			dropListCurChatrooms.addItem(room);
			rooms.add(room);
		}		
	}

	/**
	 * Remove the room from the list of rooms you are in
	 * @param room The room to remove
	 */
	public void removeRoomFromList(TRoomDropListItem room) {
		dropListCurChatrooms.removeItem(room);
		rooms.remove(room);
	}
	
	/**
	 * @param newUser -- the user to be checked
	 * @return true if newUser is already in the set of connected users.
	 */
	private boolean isInUsers(TUserDropListItem newUser) {
		for (TUserDropListItem user : users) {
			RemoteConnectionWrapper wrapper = (RemoteConnectionWrapper) user;
			RemoteConnectionWrapper newWrapper = (RemoteConnectionWrapper) newUser;
			
			if (wrapper.getUser().equals(newWrapper.getUser())) return true;
		}
		return false;
	}
	
	/**
	 * @param newRoom -- the room to be checked
	 * @return true if newRoom is already in the set of connected rooms.
	 */
	private boolean isInRooms(TRoomDropListItem newRoom) {
		for (TRoomDropListItem room : rooms) {
			ChatRoomWrapper wrapper = (ChatRoomWrapper) room;
			ChatRoomWrapper newWrapper = (ChatRoomWrapper) newRoom;
			
			if (wrapper.getRoom().equals(newWrapper.getRoom())) return true;
		}
		return false;
	}
	
//	private String roomNameMaker(String roomName) {
//		return roomName
//	}

}
