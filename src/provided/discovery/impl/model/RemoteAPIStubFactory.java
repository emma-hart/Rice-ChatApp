package provided.discovery.impl.model;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import provided.discovery.IEndPointData;
import provided.rmiUtils.IRMIUtils;

/**
 * Optional convenience factory for a specific API that can take an IEndPointData object 
 * and return the Registry-bound API-specific stub associated with the endpoint.
 * @author Stephen Wong (c) 2018
 *
 * @param <TRemoteStub>  The API-defined Remote type that is bound into the Registry
 */
public class RemoteAPIStubFactory<TRemoteStub extends Remote> {
	
	/**
	 * The IRMIUtils object the factory will use for RMI operations.
	 */
	private IRMIUtils rmiUtils;

	/**
	 * Constructor for the class.   Do NOT construct this factory until 
	 * AFTER the IRMIUtils have been started! 
	 * @param rmiUtils  The IRMIUtils object the factory will use for RMI operations.  
	 * The IRMIUtils object must be ALREADY STARTED!!
	 */
	public RemoteAPIStubFactory(IRMIUtils rmiUtils) {
		this.rmiUtils = rmiUtils;
	}
	

	/**
	 * Get the bound stub in the Registry as defined by the given IEndPointData object.
	 * Warning: Due to updating lags, there is always a possibility that the given endpoint is stale, 
	 * that is, that the associated stub is no longer bound in the Registry associated with the given endpoint.
	 * Be sure to properly catch and process any exceptions that this method may throw!
	 * @param endPt  The endpoint object with the retrieval information about the bound stub.
	 * @return The bound stub that was found.
	 * @throws RemoteException If there was an error communicating with remote Registry or
	 * an exception while communicating with the Registry.
	 * @throws NotBoundException  If the associated stub was not found in the Registry associated with endpoint.
	 */
	public TRemoteStub get(IEndPointData endPt) throws RemoteException, NotBoundException  {
		
		try {
			Registry remoteRegistry = rmiUtils.getRemoteRegistry(endPt.getAddress());
			if(endPt.isActive()) {
				@SuppressWarnings("unchecked")
				TRemoteStub stub = (TRemoteStub) remoteRegistry.lookup(endPt.getBoundName());
				return stub;
			} else {
				System.err.println("[RemoteAPIStubFactory.get("+endPt+")] Endpoint is not active!");
				throw new NotBoundException("Endpoint, "+endPt+", is not active!");
			}
		} catch (RemoteException | NotBoundException e) {
			System.err.println("[RemoteAPIStubFactory.get()] Exception while retrieving stub from remote Registry: "+e);
			e.printStackTrace();
			throw e;
		} 
	}

}
