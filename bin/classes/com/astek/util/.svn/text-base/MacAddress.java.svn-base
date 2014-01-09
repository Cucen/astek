package com.astek.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MacAddress {
	public static String getHex() {

		try {
			InetAddress address = InetAddress.getLocalHost();
			// InetAddress address = InetAddress.getByName("192.168.0.70");

			/*
			 * Get NetworkInterface for the current host and then read the
			 * hardware address.
			 */
			NetworkInterface ni = NetworkInterface.getByInetAddress(address);
			if (ni != null) {
				byte[] mac = ni.getHardwareAddress();
				if (mac != null) {
					/*
					 * Extract each array of mac address and convert it to hexa
					 * with the following format 08-00-27-DC-4A-9E.
					 */
					String macaddress = "";
					for (int i = 0; i < mac.length; i++) {
						macaddress = macaddress
								+ String.format("%02X%s", mac[i],
										(i < mac.length - 1) ? "-" : "");

					}

					return macaddress;
				} else {
					System.out.println("Address doesn't exist or is not "
							+ "accessible.");
				}
			} else {
				System.out.println("Network Interface for the specified "
						+ "address is not found.");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String loadFileAsString(String filePath)
			throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
		}
		reader.close();
		return fileData.toString();
	} /* * Get the STB MacAddress */

	public static String getMacAddress() {
		try {
			return loadFileAsString("/sys/class/net/eth0/address")
					.toUpperCase().substring(0, 17);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
