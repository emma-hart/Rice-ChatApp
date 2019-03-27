package mh65_lw31.data;

import common.IMember;
import common.message.IJoinData;

/**
 * Data for joining a chat room
 */
public class JoinData implements IJoinData {

	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -7721252180317671058L;
	/**
	 * Stub of the member to add
	 */
	private IMember repStub;
	
	/**
	 * Constructor
	 * @param repStub The stub of the member
	 */
	public JoinData(IMember repStub) {
		this.repStub = repStub;
	}

	/**
	 * The member to add 
	 * @return The member stub
	 */
	public IMember getRepToAdd() {
		return repStub;
	}
}

