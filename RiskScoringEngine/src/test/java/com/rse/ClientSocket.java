package com.rse;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClientSocket {

	public static void main(String[] args) {

		try {
			Socket s = new Socket("localhost", 1202);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Server");
			dout.flush();
			dout.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
