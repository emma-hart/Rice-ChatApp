package mh65_lw31.data;

import common.IMember;
import common.message.AMessageCmd;
import common.message.status.IStatusRejectionError;

/**
 * If you receive a request to process a well known type.
 */
public class StatusRejectionError implements IStatusRejectionError {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -3912307446605233552L;
	/**
	 * Sender of the message
	 */
	IMember sender;
	/**
	 * The well known message type being requested
	 */
	AMessageCmd<?> msg;
	
	/**
	 * Constructor
	 * @param <T> -- T type
	 * @param sender Member that asks for a request
	 * @param msg Msg ID of the well known type.
	 */
	public <T> StatusRejectionError(IMember sender, AMessageCmd<?> msg) {
		this.sender = sender;
		this.msg = msg;
	}
	
	@Override
	public String getErrorMessage() {
		return sender.toString() + " sent a well-known message type " + msg.toString();
	}

}
