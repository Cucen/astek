package com.astek.framework;

/**
 * 
 * Ekran goruntusu. Bunu arayuz yapmak yerine abstract bir sinif yaptim, cunku
 * hafizaya ilk yukleniste PlayGround ile tanimlanmis play degiskeni ataniyor.
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public abstract class Screen {

	/**
	 * 
	 * PlayGround degiskeni
	 * 
	 */
	protected final Game game;

	/**
	 * 
	 * Framework'te hazirlanan modulleri ve Screen sinifini bu arayuzde
	 * topladim.
	 * 
	 */
	public Screen(Game play) {
		this.game = play;
	}

	/**
	 * 
	 * Ekran guncellenmektedir
	 * 
	 * @param deltaTime
	 *            Donanimlar guclerine gore grafik cizimi yaparlar. Bir
	 *            donanimda bir adam sagdan sola 5 saniyede yururken baska bir
	 *            donanimda 4 saniyede yuruyebilir. Bu farki aradan kaldirmak
	 *            icin deltaTime hesaplanmaktadir.
	 */
	public abstract void update(float deltaTime);

	/**
	 * 
	 * Ekran gosterilmektedir
	 * 
	 * @param deltaTime
	 *            Donanimlar guclerine gore grafik cizimi yaparlar. Bir
	 *            donanimda bir adam sagdan sola 5 saniyede yururken baska bir
	 *            donanimda 4 saniyede yuruyebilir. Bu farki aradan kaldirmak
	 *            icin deltaTime hesaplanmaktadir.
	 */
	public abstract void present(float deltaTime);

	/**
	 * 
	 * Ekran goruntusune ara verilmektedir
	 * 
	 */
	public abstract void pause();

	/**
	 * 
	 * Ekran goruntusu devam edilmektedir
	 * 
	 */
	public abstract void resume();

	/**
	 * 
	 * Ekran goruntusune silinmektedir
	 * 
	 */
	public abstract void dispose();
}
