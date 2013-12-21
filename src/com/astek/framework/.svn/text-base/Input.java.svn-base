package com.astek.framework;

import java.util.List;

/**
 * Input arayuzunun KeyEvent ve TouchEvent olmak uzere iki alt sinifi var.
 * KeyEvent sinifi tus basimlarini kayit ederken, TouchEvent sinifi dokunma
 * bilgilerini kayit etmektedir. Ivmenin konumu icinde Input arayüzü metotlar
 * icermektedir.
 * 
 * @author Musa Cavus
 * @version 1.0
 */
public interface Input {
	// Tus basimi
	public static class KeyEvent {

		// Tusun basili konumunu 0 kabul edilmektedir.
		public static final int KEY_DOWN = 0;

		// Tusun cekili konumu 1 kabul edilmektedir.
		public static final int KEY_UP = 1;

		// Tus tipi
		public int type;

		// Tus kodu
		public int keyCode;

		// Tus karakteri
		public char keyChar;

		// Etkili tus hakkindaki bilgileri String olarak verir
		// Test amacli kullanilir.
		public String toString() {
			StringBuilder builder = new StringBuilder();
			if (type == KEY_DOWN)
				builder.append("key down, ");
			else
				builder.append("key up, ");
			builder.append(keyCode);
			builder.append(",");
			builder.append(keyChar);
			return builder.toString();
		}
	}

	// Ekran dokunma
	public static class TouchEvent {

		// Dokunma varsa 0 kabul edilmektedir.
		public static final int TOUCH_DOWN = 0;

		// Dokunma cekildiyse 1 kabul edilmektedir.
		public static final int TOUCH_UP = 1;

		// Dokunarak ekranda surukleme varsa 2 kabul edilmektedir.
		public static final int TOUCH_DRAGGED = 2;

		// Dokunma tipi
		public int type;

		// Dokunulan yerin x v y koordinatlari.
		public int x, y;

		// Multi dokunmalari tutan degisken
		public int pointer;

		// Etkili dokunma konumu hakkindaki bilgileri String olarak verir
		// Test amacli kullanilir.
		public String toString() {
			StringBuilder builder = new StringBuilder();
			if (type == TOUCH_DOWN)
				builder.append("touch down, ");
			else if (type == TOUCH_DRAGGED)
				builder.append("touch dragged, ");
			else
				builder.append("touch up, ");
			builder.append(pointer);
			builder.append(",");
			builder.append(x);
			builder.append(",");
			builder.append(y);
			return builder.toString();
		}
	}

	// Verilen parametredeki tus kodunun basimini boolean olarak verir
	public boolean isKeyPressed(int keyCode);

	// Verilen parametredeki tus kodunun cekimini boolean olarak verir
	public boolean isTouchDown(int pointer);

	// Verilen parametredeki dokunusun x koordinatini vermektedir.
	public int getTouchX(int pointer);

	// Verilen parametredeki dokunusun y koordinatini vermektedir.
	public int getTouchY(int pointer);

	// Ivmenin x koordinati iletilmektedir.
	public float getAccelX();

	// Ivmenin y koordinati iletilmektedir.
	public float getAccelY();

	// Ivmenin z koordinati iletilmektedir.
	public float getAccelZ();

	// Tus olaylarinin tutuldugu bir liste
	public List<KeyEvent> getKeyEvents();

	// Dokunma olaylarinin tutuldugu bir liste
	public List<TouchEvent> getTouchEvents();
}
