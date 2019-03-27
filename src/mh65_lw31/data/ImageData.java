package mh65_lw31.data;

import javax.swing.ImageIcon;

/**
 * Well-known image data type
 */
public class ImageData implements IImageData {
	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = 6431861071098323575L;

	/**
	 * the imageIcon to be sent
	 */
	ImageIcon data;
	
	/**
	 * Constructor
	 * @param data Component
	 */
//	public ImageData(Component data) {
//		this.data = data;
//	}
	public ImageData(ImageIcon data) {
		this.data = data;
	}

	@Override
	public ImageIcon getImageComponent() {
		return data;
	}

}
