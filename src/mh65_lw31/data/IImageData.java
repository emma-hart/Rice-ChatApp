package mh65_lw31.data;

import javax.swing.ImageIcon;

import provided.datapacket.DataPacketIDFactory;
import provided.datapacket.IDataPacketData;
import provided.datapacket.IDataPacketID;

/**
 * Interface for image data type.
 */
public interface IImageData extends IDataPacketData {
	/**
	 * @return A unique IDataPacketID based on the class. The specific type is immaterial.
	 */
	public static IDataPacketID GetID() {
		return DataPacketIDFactory.Singleton.makeID(IImageData.class);
	}
	
	@Override
	public default IDataPacketID getID() {
		return GetID();
	}
	
	/**
	 * @return the ImageIcon that this ImageData holds.
	 */
	public ImageIcon getImageComponent();
}
