package mh65_lw31.data;

import common.message.IRequestCmdData;
import provided.datapacket.IDataPacketID;

/**
 * Request Instruction
 */
public class RequestInstruction implements IRequestCmdData {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -5353817322711510634L;
	/**
	 * ID of the message
	 */
	IDataPacketID classInfo;
	
	/**
	 * Constructor
	 * @param cInfo ID of data packet
	 */
	public RequestInstruction(IDataPacketID cInfo) {
		this.classInfo = cInfo;
	}
	
	@Override
	public IDataPacketID getRequestedCmdType() {
		return classInfo;
	}

}
