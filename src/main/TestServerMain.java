package main;

import java.io.IOException;

import framework2.PlayerColors;
import standard.server.NetworkPlayerServer;

public class TestServerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NetworkPlayerServer server = new NetworkPlayerServer(25565, PlayerColors.Red);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
