package standard.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import framework2.Player;

public class NetworkClient {
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public NetworkClient(InetAddress adress, int port,Player player) throws IOException, InterruptedException, ClassNotFoundException{
		Socket socket = new Socket(adress, port);
		
		System.out.println("connected");
		OutputStream outstream = socket.getOutputStream();
		InputStream instream = socket.getInputStream();
		
		out = new ObjectOutputStream(outstream);
		in = new ObjectInputStream(instream);
	}
	

	private void listen(){
		
	}
}
