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
import framework2.Colors;
import framework2.Unit;
import framework2.World;

public class NetworkPlayerServer implements Player {
	
	private int port;
	private Colors color;
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public NetworkPlayerServer(int port, Colors color) throws IOException{
		this.port = port;
		this.color = color;
		
		System.out.println("Server started " +  color);
		
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
		try {
			out.writeUTF("placeUnit");
			out.flush();
			out.reset();
			out.writeObject(unit);
			out.flush();
			out.reset();
			
			Location loc = (Location) in.readObject();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
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
		System.out.println("switch units");
		try {
			out.writeUTF("switchUnit");
			out.flush();
			out.reset();
			
			Location[] loc = (Location[]) in.readObject();
			
			System.out.println("Got switch unit locations from client");

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
			out.writeUTF("endInitPhase");
			out.flush();
			out.reset();
			
			Boolean b = in.readBoolean();
			return b;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void updateWorld(World world) {
		try {
			out.writeUTF("updateWorld");
			out.flush();
			out.reset();
			out.writeObject(world);
			out.flush();
			out.reset();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Location[] getMove(World world) {
		try {
			out.writeUTF("updateWorld");
			out.flush();
			out.reset();
			out.writeObject(world);
			out.flush();
			out.reset();
			
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
