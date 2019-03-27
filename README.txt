Comp310 Fall 2018, ChatApp
Team: Michelle Huang, Rocky Wu

[Starting the App]
To start the ChatApp, right click the ChatAppController.launch file in the root HW08 folder and click 'Run'. 
The app's GUI consists of a top control panel, a middle chatroom tabbed panel (initially hidden), and a system 
status display panel.

[Connecting to a remote user]
To connect to a remote user, type his/her IP address into the Remote User textbox, then press 'Connect'.
If a remote user connects to this ChatApp, we support the auto-connect back feature. This is evident by
noticing that in both cases, the user's name will be added to 'Connected Users' list.

[Creating a chatroom]
To create a chatroom, type a desired name into the textfield under 'Create Room' and then press 'Create'. 
The room with its corresponding name should pop up in a new tab in the middle of the screen. This room 
should also appear in the dropdownlist under 'Your Rooms'.

[Joining a chatroom]
To join a chatroom, select a user from the list connected users which should open the list of rooms that they 
are in in the dropdownlist under 'User's Rooms'. Select the room that you wish to join, and then click 'Join'. 
This room should appear in the dropdownlist under Your Rooms and the new chatroom tabbed pane should appear.
We've also covered corner cases that the room will not be continuously added to 'Your Rooms' if a user keeps 
clicking on 'Join'.

[Inviting a connected user to a chatroom]
-create, join, invite to chatrooms
To invite a connected user to a chatroom, you can create a chatroom or just select a room from your list of 
rooms under 'Your Rooms', select the user you want to invite under 'Connected Users', and then click 'Invite'. 
This user would then be added to that chatroom and have the ability to send/receive messages.

[Message Sending Capabilities]
Text message -- Type a message in the textbox and press 'Send Msg'.
Leaving Chatroom -- Press 'Leave Room' and an ILeaveData message will be broadcasted to all the members
in this room.
Sending our unknown message -- Press 'Send Unknown' and it will go back and forth with the other members
and teach them how to process the unknown message. The outcome is displaying a FIFA_Soccer_Ball.png.

[Quitting the App]
Press the Quit button and it will remove the user from all of the room(s) they're currently in and exit 
the ChatApp.

[Error Status]
There are 3 error statuses: 
1. IStatusSendingError - You will receive a message of the member that caused the exception.
2. IStatusProcessingError - You will receive a message of the member and the ID of the message 
that caused the exception.
3. IStatusRejectionError - You will receive a message of the member and the data of the message 
that caused the exception.

[Well-known message types]
ITxtData; IJoinData, ILeaveData; IRequestCmdData, IInstallCmdData; IStatusProcessingError, IStatusRejectionError,
IStatusSendingError.
Commands for processing these data types are installed in the visitor in ChatRoomModel.

[Our unknown message type]
Our unknown message type is called mh65_lw31.data.IImageData. When a remote user receives this message type, he/she
can expect to see a picture of images/FIFA_Soccer_Ball.png pop up as per his/her ICmd2ModelAdapter's addGUIComponent()
implementation.

[Use-Case Diagram and UML Diagrams]
The use case diagram will be in the root folder of HW08 named HW08_usecase.png. 
There are UML diagrams in the root folder as well as for the chatroom, chatapp, data, and util.

[Javadoc]
The generated Javadoc for our package mh65_lw31 can be found under HW08/doc/mh65_lw31.