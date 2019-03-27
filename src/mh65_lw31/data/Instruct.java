package mh65_lw31.data;

import common.message.AMessageCmd;
import common.message.IInstallCmdData;
import provided.datapacket.IDataPacketData;
import provided.datapacket.IDataPacketID;

/**
 * Instruct 
 */
public class Instruct implements IInstallCmdData {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = 3094901486092199622L;
	/**
	 * Command of the message
	 */
	AMessageCmd<? extends IDataPacketData> cmd;
	/**
	 * ID of the message
	 */
	IDataPacketID cmdID;
	
	/**
	 * Constructor
	 * @param id ID of the data packet
	 * @param aCmd Command of data packet to install
	 */
	public Instruct(IDataPacketID id, AMessageCmd<?> aCmd) {
		this.cmdID = id;
		this.cmd = aCmd;
	}
	
//	@Override
//	public ADataPacketAlgoCmd<?, ?, ?, ?, ?> getCmd() {
//		// TODO Auto-generated method stub
//		return cmd;
//	}

	@Override
	public AMessageCmd<?> getCmdToInstall() {
		return cmd;
	}

	@Override
	public IDataPacketID getInstallCmdType() {
		return cmdID;
	}

}
