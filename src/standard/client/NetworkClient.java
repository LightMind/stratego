package standard.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import framework2.Location;
import framework2.Player;
import framework2.Unit;
import framework2.World;

public class NetworkClient {
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Player player;
	private Socket socket;
	
	public NetworkClient(InetAddress adress, int port,Player player) throws IOException, InterruptedException, ClassNotFoundException{
		socket = new Socket(adress, port);
		this.player = player;
		System.out.println("connected");
		OutputStream outstream = socket.getOutputStream();
		InputStream instream = socket.getInputStream();
		
		out = new ObjectOutputStream(outstream);
		in = new ObjectInputStream(instream);
	}
	

	public void listen() throws ClassNotFoundException, IOException{
		while(true){
			Object o = in.readObject();
			String msg = (String) o;
			switch(msg){
			case "updateWorld": updateWorld() ;break;
			case "switchUnits": switchUnits() ;break;
			case "placeUnit": placeUnit(); break;
			case "endInitPhase": endInitPhase() ;break;
			case "getMove": getMove(); break;
			}
			
		}
	}
	
	public void close() throws IOException{
		socket.close();
	}
	
	


	private void getMove() throws ClassNotFoundException, IOException {
		World w = (World) in.readObject();
		Location[] loc = player.getMove(w);
		out.writeObject(loc);
		out.flush();
	}


	private void endInitPhase() throws IOException {
		boolean b = player.endInitPhase();
		out.writeBoolean(b);
		out.flush();
		
	}


	private void placeUnit() throws ClassNotFoundException, IOException {
		Unit u = (Unit) in.readObject();
		Location loc = player.placeUnit(u);
		out.writeObject(loc);
		out.flush();
		
	}


	private void switchUnits() throws IOException {
		Location[] locs = player.switchUnits();
		out.writeObject(locs);
		out.flush();
		
	}


	private void updateWorld() throws ClassNotFoundException, IOException {
		World w = (World) in.readObject();
		player.updateWorld(w);
	}
}
