package com.astek.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * Dosyalama sistemini kullanabilmek icin Java'nin InputStream ve OutputStream
 * kutuphanelerinden yararlanilmaktadir. Asset'leri APK dosyasinda
 * okuyabildigimiz icin sadece okuma metodu kullanilmistir.
 * <p>
 * SD kartindan okuma ve SD kartina yazma içinde iki metot dahah eklendi.
 * <p>
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public interface FileIO {

	/**
	 * 
	 * Asset dizininde olan dosyalari okumaktadir.
	 * 
	 * @param fileName
	 *            Okunacak dosyanin adi.
	 * 
	 * @return InputStream olarak okunan deger iletilmektedýr.
	 */
	public InputStream readAsset(String fileName) throws IOException;

	/**
	 * 
	 * SD kartinda olan dosyalari okumaktadir.
	 * 
	 * @param fileName
	 *            Okunacak dosyanin adi.
	 * 
	 * @return InputStream olarak okunan deger iletilmektedýr.
	 */
	public InputStream readFile(String fileName) throws IOException;

	/**
	 * 
	 * SD kartina dosyalar yazilmaktadir.
	 * 
	 * @param fileName
	 *            Yazilacak dosyanin adi.
	 * 
	 * @return OutputStream olarak okunan deger iletilmektedýr.
	 */
	public OutputStream writeFile(String fileName) throws IOException;
}
