package mh65_lw31.data;

import common.IMember;
import common.message.status.IStatusSendingError;

/**
 * Status Error.
 */
public class StatusSendingError implements IStatusSendingError {
	/**
	 * Generated ID.
	 */
	private static final long serialVersionUID = 1176525632262885387L;
	/**
	 * The member that disconnected
	 */
	IMember mem;
	
	/**
	 * Constructor
	 * @param mem Member that has a Remote Exception.
	 */
	public StatusSendingError(IMember mem) {
		this.mem = mem;
	}
	@Override
	public IMember getMember() {
		return mem;
	}
	@Override
	public String getErrorMessage() {
		return mem.toString() + " of the chatroom has left without being properly disconnected.";
	}

}
