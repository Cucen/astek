package com.astek.framework;

/**
 * 
 * Muzik ya da uzun ses dosyalarini oynatabilmek icin gerekli olan bir arayuz.
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public interface Music {

	/**
	 * 
	 * Muzik dosyasini oynatir
	 * 
	 */
	public void play();

	/**
	 * 
	 * Oynayan muzik dosyasini durdurur
	 * 
	 */
	public void stop();

	/**
	 * 
	 * Oynayan muzik dosyasini duraklatir
	 * 
	 */
	public void pause();

	/**
	 * 
	 * Muzik dongusu ayarlanir
	 * 
	 * @param looping
	 *            dongu yapilacaksa true yapilmayacaksa false
	 * 
	 */
	public void setLooping(boolean looping);

	/**
	 * 
	 * Ses yuksekligi ayarlanir
	 * 
	 * @param volume
	 *            ses yuksekligi ayarlanir
	 * 
	 */
	public void setVolume(float volume);

	/**
	 * 
	 * Oynayan bir muzik var mi
	 * 
	 * @return boolean oynayan bir muzik varsa true yoksa false
	 * 
	 */
	public boolean isPlaying();

	/**
	 * 
	 * Oynayan muzik durdu mu
	 * 
	 * @return boolean duran muzik varsa true yoksa false
	 * 
	 */
	public boolean isStopped();

	/**
	 * 
	 * Oynayan muzik dongude mi
	 * 
	 * @return boolean dongude muzik varsa true yoksa false
	 * 
	 */
	public boolean isLooping();

	/**
	 * 
	 * Muzigi yok eder.
	 * 
	 */
	public void dispose();
}
