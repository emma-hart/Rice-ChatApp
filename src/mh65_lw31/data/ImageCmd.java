package mh65_lw31.data;

import java.awt.Component;
import java.util.function.Supplier;

import javax.swing.JLabel;

import common.message.AMessageCmd;
import common.message.ChatroomDataPacket;
import provided.datapacket.IDataPacketID;

/**
 * Command for image data type.
 */
public class ImageCmd extends AMessageCmd<IImageData>{

	/**
	 * Generated ID 
	 */
	private static final long serialVersionUID = 4388015296993331031L;
	
	//private ICmd2ModelAdapter _c2mAdpt;
	
	/**
	 * Constructor
	 */	
	public ImageCmd() {}

	@Override
	public Void apply(IDataPacketID index, ChatroomDataPacket<IImageData> host, Void... params) {
		//image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		
		this._cmd2ModelAdpt.addComponentFactory(new Supplier<Component> () {
			@Override
			public Component get() {
				//return host.getData().getImageComponent();
				
				return new JLabel(host.getData().getImageComponent());
			}
		});
		return null;
	}
}
