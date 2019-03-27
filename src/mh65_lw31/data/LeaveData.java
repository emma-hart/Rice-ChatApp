package mh65_lw31.data;

import common.IMember;
import common.message.ILeaveData;

/**
 * Leave data
 */
public class LeaveData implements ILeaveData {
	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = 7067177544491880559L;
	/**
	 * Stub of the members
	 */
	IMember repStub;
	
	/**
	 * Constructor
	 * @param rep IMember to leave
	 */
	public LeaveData(IMember rep) {
		this.repStub = rep;
	}
//
//	public IMember getRepToRemove() {
//		return repStub;
//	}

}
