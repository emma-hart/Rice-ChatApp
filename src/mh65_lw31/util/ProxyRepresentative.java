package mh65_lw31.util;


/**
 * Private class to decorate an IUser to override the equals() and hashCode() 
 * methods so that a dictionary, e.g. Hashtable, can properly compare IUsers.
 * @author swong
 *
 */
  public class ProxyRepresentative {}	
////public class ProxyRepresentative implements IRepresentative, Serializable {	/**
//	 * Required for proper serialization
//	 */
//	private static final long serialVersionUID = 5682755540794448769L; // regenerate this!
//	
//	/**
//	 * The decoree
//	 */
//	private IRepresentative stub;
//
//	/**
//	 * Constructor for the class
//	 * @param stub The decoree
//	 */
//	public ProxyRepresentative(IRepresentative stub){
//		this.stub = stub;
//	}
//
//	/**
//	 * Get the decoree
//	 * @return the decoree
//	 */
//	public IRepresentative getStub() {
//		return stub;
//	}
//	
//	public void setStub(IRepresentative stub) {
//		this.stub = stub;
//	}
//	
//	/**
//	 * No-op decoration of the getName method.   Just pass the request to the decoree.
//	 * @return The name of the user.
//	 */
//	public String getUserName() throws RemoteException {
//		return stub.getUserName();
//	}
//
//	public void receiveMessage(ADataPacket D) throws RemoteException {
//		stub.receiveMessage(D);		
//	}
//
//
////	/**
////	 * No-op decoration of the sendMsg method.   Just pass the request to the decoree.
////	 * @param data The data to be sent
////	 * @param sender  The sender of the data
////	 * @return The status of the transmission
////	 * @throws RemoteException
////	 */
////	@Override
////	public IStatus sendMsg(ADataPacket data, IUser sender) throws RemoteException {
////		return stub.sendMsg(data, sender);
////	}
//
//
//	/**
//	 * Overriden equals() method to simply compare hashCodes.
//	 * @return  Equal if the hashCodes are the same.  False otherwise.
//	 */
//	@Override
//	public boolean equals(Object other){
//		return hashCode() == other.hashCode();
//	}
//	
//
//	/**
//	 * Overriden hashCode() method to create a hashcode from all the accessible values in IUser.
//	 * @return a hashCode tied to the values of this IUser.	
//	 */
//	@Override
//	public int hashCode() {
//		//return stub.getID().hashCode();
//		try {
//			// Only name is available for now.
//			return stub.getID().hashCode();
//		} catch (RemoteException e) {
//			// Deal with the exception without throwing a RemoteException.
//			System.err.println("ProxyStub.hashCode(): Error calling remote method on IUser stub: "+e);
//			e.printStackTrace();
//			return super.hashCode();
//		}
//	}
//
//	@Override
//	public IChatRoom getRoom() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public UUID getID() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setRoom(IChatRoom chatroom) {
//		// TODO Auto-generated method stub
//		
//	}	
//}