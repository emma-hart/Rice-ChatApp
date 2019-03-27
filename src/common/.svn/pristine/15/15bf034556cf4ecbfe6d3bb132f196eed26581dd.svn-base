package common.message;


import common.ICmd2ModelAdapter;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.IDataPacketData;


/**
/**
 * An abstract class that all commands should extend. This class helps with type narrowing to allow for easier debugging.
 * @param <T> A sub type of IDataPacketData. The type of data that the command will act upon
 * 
 */
public abstract class AMessageCmd<T extends IDataPacketData> extends ADataPacketAlgoCmd<Void, T, Void, ICmd2ModelAdapter, ChatroomDataPacket<T>> {

	
	/**
	 * Auto generated serial version ID.
	 */
	private static final long serialVersionUID = -2211087162454226206L;
	
	/**
	 * An adapter that allows this command to access the local model.
	 */
	protected transient ICmd2ModelAdapter _cmd2ModelAdpt;

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this._cmd2ModelAdpt = cmd2ModelAdpt;
		System.out.println("Set command-to-model adapter: " + cmd2ModelAdpt);
	}

}