package mh65_lw31.chatroom.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * View of the chat room
 */
public class ChatRoomView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5925793743594080359L;

	/**
	 * Adapter for the view to model of the chatroom.
	 */
	private IChatRoomView2ModelAdapter v2mAdpt;
	
	/* Start of Component Definitions */
	/**
	 * Holds the display and control panel.
	 */
	private final JPanel mainPanel = new JPanel();
	/**
	 * Panel for messaging.
	 */
	private final JPanel controlPanel = new JPanel();
	/**
	 * Panel for the display.
	 */
	private final JScrollPane displayPanel = new JScrollPane();
	
	/* Display Panels */
	/**
	 * Area that displays the messages.
	 */
	private final JTextArea textAreaRoom = new JTextArea(15,25);
	/**
	 * Panel for status.
	 */
	private final JPanel panelText = new JPanel();
	
	/* Control panels */
//	private final JPanel panelUser = new JPanel();
//	private final JTextField textFieldUser = new JTextField();
//	private final JButton btnUserName = new JButton("Set Username");
	
//	private final JPanel panelList = new JPanel();
	/**
	 * 
	 */
	private final JTextField textField = new JTextField();
	/**
	 * Button to send a message in a chatroom.
	 */
	private final JButton btnSendMsg = new JButton("Send Msg");
	/**
	 * Panel for messaging and chatrooms.
	 */
	private final JPanel panelMessage = new JPanel();
//	private final JButton btnSendMsg = new JButton("Send Msg");
//	private final JComboBox<TTextDropListItem> dropListMessage = new JComboBox();
	/**
	 * Button to leave the chatroom.
	 */
	private final JButton btnLeave = new JButton("Leave Room");
	/**
	 * Button to send unknown message.
	 */
	private final JButton btnSendUnknown = new JButton("Send Unknown");
	
	/* End of Component Definitions */
	
	/**
	 * Constructor
	 * @param adpt IChatRoomView2ModelAdapter
	 */
	public ChatRoomView(IChatRoomView2ModelAdapter adpt) {
		this.v2mAdpt = adpt;
		initGUI();
	}
	
	/**
	 * Starts the view
	 */
	public void start() {
		setVisible(true);
	}
	
	/**
	 * Initializes the view.
	 */
	private void initGUI(){
		//setSize(200, 200);
		mainPanel.setLayout(new FlowLayout());
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.add(displayPanel);
		mainPanel.add(controlPanel);		
		
		/* Display Panel */
		//displayPanel.setViewportView(textAreaRoom);
		displayPanel.setViewportView(panelText);
		panelText.add(textAreaRoom);
		//panelText.setLayout(mgr);

		/* Messaging Panels */
		controlPanel.setLayout(new GridLayout(3, 1));
//		controlPanel.add(panelUser);
//		panelUser.setLayout(new BorderLayout(0, 0));
//		textFieldUser.setColumns(10);
//		panelUser.add(textFieldUser, BorderLayout.CENTER);
//		panelUser.add(btnUserName, BorderLayout.SOUTH);
		
//		controlPanel.add(panelList);
//		panelList.setLayout(new BorderLayout(0, 0));
//		textField.setColumns(10);
//		panelList.add(textField, BorderLayout.CENTER);
//		btnAddToList.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TTextDropListItem text = v2mAdpt.addText(textField.getText());
//				dropListMessage.addItem(text);
//			}
//		});
//		panelList.add(btnAddToList, BorderLayout.SOUTH);
		
		controlPanel.add(panelMessage);
		panelMessage.setLayout(new BorderLayout(0, 0));
		textField.setColumns(10);
		panelMessage.add(textField, BorderLayout.NORTH);

//		panelMessage.add(dropListMessage, BorderLayout.CENTER);
		
		btnSendUnknown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v2mAdpt.sendImage(textField.getText());
			}
		});
		btnSendUnknown.setToolTipText("Send unknown message.");
		panelMessage.add(btnSendUnknown, BorderLayout.SOUTH);
		
		panelMessage.add(btnSendMsg, BorderLayout.CENTER);
		btnSendMsg.setToolTipText("Send message to chatroom.");
		btnSendMsg.addActionListener(e -> {
			v2mAdpt.sendText(textField.getText());
			//v2mAdpt.sendText(dropListMessage.getItemAt(dropListMessage.getSelectedIndex()));
		});
//		btnSendMsg.addActionListener(e -> {
//			v2mAdpt.sendText(textField.getText());
//		});
		controlPanel.add(btnLeave);
		btnLeave.addActionListener(e -> {
			v2mAdpt.leaveRoom();
			v2mAdpt.removeRoomfromList();
		});
	}
	
	/**
	 * Send a message
	 * @param msg The message to send
	 */
	public void sendMsg(String msg) {
		//System.out.println("Chatroom view debug 1");
		textAreaRoom.append(msg + "\n");
		//JLabel label = new JLabel(msg);
		//panelText.add(label);
		//panelText.revalidate();
	}
	
	/**
	 * Add GUI component
	 * @param component The component to add
	 */
	public void addComponent(Component component) {
		//panelText.add(component);
		//panelText.revalidate();
		JFrame messageFrame = new JFrame("New GUI Component");
		messageFrame.getContentPane().add(component);
		messageFrame.setPreferredSize(new Dimension(600, 600));
		messageFrame.pack();
		messageFrame.setLocationRelativeTo(null);
		messageFrame.setVisible(true);
	}
}
