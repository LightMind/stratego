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
		System.out.println("placeUnit " + color);
		try {
			out.writeObject("placeUnit");
			out.writeObject(unit);
			out.flush();
			
			Location loc = (Location) in.readObject();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return loc;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Location[] switchUnits() {
		try {
			out.writeObject("switchUnit");
			out.flush();
			
			Location[] loc = (Location[]) in.readObject();

			return loc;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean endInitPhase() {
		try {
			out.writeObject("endInitPhase");
			out.flush();
			
			Boolean b = in.readBoolean();
			return b;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void updateWorld(World world) {
		System.out.println("updateWorld " + color);
		try {
			out.writeObject("updateWorld:");
			System.out.println(world);
			out.writeObject(world);
			System.out.println(world);
			out.flush();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Location[] getMove(World world) {
		try {
			out.writeObject("updateWorld");
			out.writeObject(world);
			out.flush();
			
			Location[] loc = (Location[]) in.readObject();
			
			return loc;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
