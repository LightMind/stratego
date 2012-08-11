package standard.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import framework2.Location;
import framework2.Player;
import framework2.Unit;
import framework2.World;

public class TestClientMain {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Player p = new Player() {
			
			@Override
			public void updateWorld(World world) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int[] switchUnits() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Location placeUnit(Unit unit) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int[] getMove(World world) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean endInitPhase() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		InetAddress add = new InetSocketAddress("84.238.35.42", 25565).getAddress();
		NetworkClient cl = new NetworkClient(add, 25565, p);
		
	}

}
