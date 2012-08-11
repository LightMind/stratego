package standard.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import framework2.Location;
import framework2.Player;
import framework2.PlayerColors;
import framework2.Unit;
import framework2.World;

public class NetworkPlayerServer implements Player {
	
	private int port;
	private PlayerColors color;
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public NetworkPlayerServer(int port, PlayerColors color) throws IOException{
		this.port = port;
		this.color = color;
		
		System.out.println("Server started");
		
		ServerSocket server = new ServerSocket(port);
		Socket client = server.accept();
		System.out.println("Client connected");
		
	
		InputStream instream = client.getInputStream();
		OutputStream outstream = client.getOutputStream();
		
		in = new ObjectInputStream(instream);
		out = new ObjectOutputStream(outstream);
		
	
	}
	
	@Override
	public Location placeUnit(Unit unit) {
		return null;
	}

	@Override
	public Location[] switchUnits() {
		return null;
	}

	@Override
	public boolean endInitPhase() {
		
		return false;
	}

	@Override
	public void updateWorld(World world) {
		

	}

	@Override
	public Location[] getMove(World world) {
		return null;
	}

}
