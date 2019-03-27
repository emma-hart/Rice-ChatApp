/**
 * 
 */
/**
 * @author Rocmeister
 *
 */
module HW08 {
	requires transitive java.desktop;
	requires transitive java.rmi;
	requires org.junit.jupiter.api;
	//exports common.api;
	exports common;
	exports common.message;
	exports common.message.status;
	exports provided.datapacket;
	exports provided.discovery;
	exports provided.rmiUtils;
	//exports provided.datapacket;
}