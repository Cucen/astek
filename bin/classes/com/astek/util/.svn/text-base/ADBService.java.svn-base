package com.astek.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class ADBService {
	
	public static final String PORT = "5555";
	
	public static boolean adbStart() {
		try {
			setProp("service.adb.tcp.port", PORT);
			if (isProcessRunning("adbd")) {
				runRootCommand("stop adbd");
			}
			runRootCommand("start adbd");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean adbStop() {
		try {
			setProp("service.adb.tcp.port", "-1");
			runRootCommand("stop adbd");
			runRootCommand("start adbd");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean runRootCommand(String command) {
		Process process = null;
		DataOutputStream os = null;
		try {
			process = Runtime.getRuntime().exec("su");
			os = new DataOutputStream(process.getOutputStream());
			os.writeBytes(command + "\n");
			os.writeBytes("exit\n");
			os.flush();
			process.waitFor();
		} catch (Exception e) {
			return false;
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				process.destroy();
			} catch (Exception e) {
			}
		}
		return true;
	}

	public static boolean setProp(String property, String value) {
		Process process = null;
		DataOutputStream os = null;
		try {
			process = Runtime.getRuntime().exec("su");
			os = new DataOutputStream(process.getOutputStream());
			os.writeBytes("setprop " + property + " " + value + "\n");
			os.writeBytes("exit\n");
			os.flush();
			process.waitFor();
		} catch (Exception e) {
			return false;
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				process.destroy();
			} catch (Exception e) {
			}
		}
		return true;
	}

	public static boolean isProcessRunning(String processName) {
		try {
			boolean running = false;
			Process process = null;
			process = Runtime.getRuntime().exec("ps");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				if (line.contains(processName)) {
					running = true;
					break;
				}
			}
			in.close();
			process.waitFor();
			return running;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean hasRootPermission() {
		Process process = null;
		DataOutputStream os = null;
		boolean rooted = true;
		try {
			process = Runtime.getRuntime().exec("su");
			os = new DataOutputStream(process.getOutputStream());
			os.writeBytes("exit\n");
			os.flush();
			process.waitFor();
			if (process.exitValue() != 0) {
				rooted = false;
			}
		} catch (Exception e) {
			rooted = false;
		} finally {
			if (os != null) {
				try {
					os.close();
					process.destroy();
				} catch (Exception e) {
				}
			}
		}
		return rooted;
	}

}
