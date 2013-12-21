package com.astek.framework;

import com.astek.framework.Graphics.PixmapFormat;

/**
 * 
 * Resim bilgileri
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public interface Pixmap {

	/**
	 * 
	 * Genislik bilgisi
	 * 
	 */
	public int getWidth();

	/**
	 * 
	 * Yukseklik bilgisi
	 * 
	 */
	public int getHeight();

	/**
	 * 
	 * Resim formatik
	 * 
	 * @return PixmapFormat seklinde formati iletir.
	 */
	public PixmapFormat getFormat();

	/**
	 * 
	 * Resmi yoket
	 * 
	 */
	public void dispose();
}
