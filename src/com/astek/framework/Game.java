package com.astek.framework;

import android.content.Context;

/**
 * 
 * Framework'te hazirlanan modulleri ve Screen sinifini bu arayuzde topladim.
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public interface Game {

	/**
	 * 
	 * Giris bilgisi
	 * 
	 * @return Giris bilgisini Input halinde iletmektedir.
	 */
	public Input getInput();

	/**
	 * 
	 * Dosyalama bilgisi
	 * 
	 * @return Dosyalama bilgisini FileIO halinde iletmektedir.
	 */
	public FileIO getFileIO();

	/**
	 * 
	 * Grafik bilgisi
	 * 
	 * @return Grafik bilgisini Graphics halinde iletmektedir.
	 */
	public Graphics getGraphics();

	/**
	 * 
	 * Ses ve Muzik bilgisi
	 * 
	 * @return Ses ve Muzik bilgilerini Audio halinde iletmektedir.
	 */
	public Audio getAudio();

	/**
	 * 
	 * Ekrani set eder
	 * 
	 * @param screen
	 *            set edilmek istenen ekran
	 */
	public void setScreen(Screen screen);

	/**
	 * 
	 * Aktif olan ekran
	 * 
	 * @return aktif olan ekran
	 */	
	public Screen getCurrentScreen();

	/**
	 * 
	 * Ilk ekran
	 * 
	 * @return Ilk ekran.
	 */
	public Screen getStartScreen();
	
	public Context getContext();

}
