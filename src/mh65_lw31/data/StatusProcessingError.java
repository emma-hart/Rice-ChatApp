package mh65_lw31.data;

import common.IMember;
import common.message.status.IStatusProcessingError;
import provided.datapacket.IDataPacketID;

/**
 * This is the well-known status error message that is sent when something goes wrong during
 * processing of a message by a visitor.
 */
public class StatusProcessingError implements IStatusProcessingError {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -2820570592986714655L;
	/**
	 * Sender of the message
	 */
	IMember sender;
	/**
	 * ID of the message causing the error
	 */
	IDataPacketID id;
	
	/**
	 * Constructor
	 * @param <T> -- T type
	 * @param sender Member that asks for a request 
	 * @param id ID of the well known type
	 */
	public <T> StatusProcessingError(IMember sender, IDataPacketID id) {
		this.sender = sender;
		this.id = id;
	}
	
	@Override
	public String getErrorMessage() {
		return sender.toString() + " cannot process this message type " + id.toString();
	}

}
