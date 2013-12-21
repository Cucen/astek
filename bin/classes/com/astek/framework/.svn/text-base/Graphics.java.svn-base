package com.astek.framework;

import android.content.Context;

/**
 * 
 * Iki boyutlu ortamlarda grafik cizimi yapabilmek icin kullanilan bir arayuz.
 * Belirli bir boyutu olan ekrandaki her noktaya piksel denilmektedir ve her
 * pikselin bir koordinati ile bir rengi var. Koordinatlar ekranin sol ust
 * kosesinden basliyor. Ekranin en sol ust kosesi koordinat olarak 0:0 olarak
 * tanimlanmistir.
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public interface Graphics {

	/**
	 * 
	 * Ornek olarak aciklamak istiyorum. Diyelim ki bir resim dosyasini cok iyi
	 * bir kalite olan piksel basi 32 bit istiyorsak ARGB8888 kullanarak
	 * yaklasik 4MB'lik bir hafiza parcasini ayirmis oluruz. Ayni resmi RGB565
	 * yani 16 bit ile desifre edersek 2MB'lik bir alana ihtiyac duyariz.
	 * <p>
	 * Bir resim cizebilmek icin su adimlari uygalayacagim:
	 * <li>Resmi diskten yukle ve hafizaya yukle</li>
	 * <li>Framebuffer'i sil ve bir sonraki resim cizilince eski resim
	 * kalintilari kalmasin</li>
	 * <li>Bir noktayi Framebuffer'de herhangi koordinatta belirli bir renk ile
	 * ayarla</li>
	 * <li>Cizgiler ve dortgenleri Framebuffer'a ciz</li>
	 * <li>Framebuffer boyutunu ogren</li>
	 * <p>
	 */
	public static enum PixmapFormat {
		ARGB8888, ARGB4444, RGB565
	}

	/**
	 * 
	 * JPEG ve PNG formatindaki bir resim yukleniyor.
	 * 
	 * @param fileName
	 *            Okunacak dosyanin adi.
	 * 
	 * @param format
	 *            Okunacak format kalitesi
	 * 
	 * @return Pixmap olarak okunan deger iletilmektedir.
	 */
	public Pixmap newPixmap(String fileName, PixmapFormat format);

	/**
	 * 
	 * Verilen renge gore Framebuffer'i silmektedir
	 * 
	 * @param color
	 *            Framebuffer'i silme rengi
	 * 
	 */
	public void clear(int color);

	/**
	 * 
	 * Verilen koordinatta ve verilen renkte nokta cizer
	 * 
	 * @param x
	 *            x koordinati
	 * 
	 * @param y
	 *            y koordinati
	 * 
	 * @color cizilmek istenen renk
	 */
	public void drawPixel(int x, int y, int color);

	/**
	 * 
	 * Verilen koordinatta ve verilen renkte cizgi cizer
	 * 
	 * @param x
	 *            x koordinati
	 * 
	 * @param y
	 *            y koordinati
	 * 
	 * @param x2
	 *            x2 koordinati
	 * 
	 * @param y2
	 *            y2 koordinati
	 * 
	 * @color cizilmek istenen renk
	 */
	public void drawLine(int x, int y, int x2, int y2, int color);

	/**
	 * 
	 * Verilen koordinatlarda ve verilen renkte dikdortgen cizer
	 * 
	 * @param x
	 *            x koordinati
	 * 
	 * @param y
	 *            y koordinati
	 * 
	 * @param width
	 *            genislik
	 * 
	 * @param height
	 *            yukseklik
	 * 
	 * @color cizilmek istenen renk
	 */
	public void drawRect(int x, int y, int width, int height, int color);

	/**
	 * 
	 * Pixmap ile verilen belirli bir bolumu cizer
	 * 
	 * @param pixmap
	 *            Resim icerigi
	 * 
	 * @param x
	 *            x koordinati
	 * 
	 * @param y
	 *            y koordinati
	 * 
	 * @param srcX
	 *            resimdeki okunacak x koordinati
	 * 
	 * @param srcY
	 *            resimdeki okunacak y koordinati
	 * 
	 * @param srcWidth
	 *            okunacak resim bolumun genisligi
	 * 
	 * @param srcHeight
	 *            okunacak resim bolumun yuksekligi
	 * 
	 */

	public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
			int srcWidth, int srcHeight);

	/**
	 * 
	 * Pixmap ile verilen belirli bir bolumu cizer
	 * 
	 * @param pixmap
	 *            Resim icerigi
	 * 
	 * @param x
	 *            x koordinati
	 * 
	 * @param y
	 *            y koordinati
	 */
	public void drawPixmap(Pixmap pixmap, int x, int y);

	/**
	 * 
	 * Genislik bilgisi
	 */
	public int getWidth();

	/**
	 * 
	 * Yukseklik bilgisi
	 */
	public int getHeight();
	
	public void drawVideoView(Context context);
}
