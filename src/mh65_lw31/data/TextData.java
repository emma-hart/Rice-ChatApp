package mh65_lw31.data;

import common.message.ITxtData;

/**
 * Text data.
 */
public class TextData implements ITxtData {
	/**
	 * Generated ID
	 */
	private static final long serialVersionUID = -3333758160659542088L;
	/**
	 * Text data
	 */
	String data;
	
	/**
	 * Constructor
	 * @param data String input
	 */
	public TextData(String data) {
		this.data = data;
	}

	@Override
	public String getTxt() {
		return data;
	}
	
	@Override
	public String toString() {
		return data;
	}


}
