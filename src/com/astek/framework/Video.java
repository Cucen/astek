package com.astek.framework;

/**
 * 
 * Video dosyalarini oynatabilmek icin gerekli olan bir arayuz.
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public interface Video {

	/**
	 * 
	 * Video dosyasini oynatir
	 * 
	 */
	public void play();

	/**
	 * 
	 * Oynayan video dosyasini durdurur
	 * 
	 */
	public void stop();

	/**
	 * 
	 * Oynayan video dosyasini duraklatir
	 * 
	 */
	public void pause();

	/**
	 * 
	 * Video dongusu ayarlanir
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
	 * Oynayan video durdu mu
	 * 
	 * @return boolean duran muzik varsa true yoksa false
	 * 
	 */
	public boolean isStopped();

	/**
	 * 
	 * Oynayan video dongude mi
	 * 
	 * @return boolean dongude video varsa true yoksa false
	 * 
	 */
	public boolean isLooping();

	/**
	 * 
	 * Videoyu yok eder.
	 * 
	 */
	public void dispose();
}
