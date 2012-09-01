package standard.server;

import java.io.IOException;

import standard.GameInitPhase;

import framework2.EditableWorld;
import framework2.Colors;

public class ServerApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NetworkPlayerServer playerRed = null;
		NetworkPlayerServer playerBlue = null;
		try {
			playerRed = new NetworkPlayerServer(25565, Colors.Red);
			playerBlue = new NetworkPlayerServer(25566, Colors.Blue);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GameInitPhase initGame = new GameInitPhase(playerRed, playerBlue);
		EditableWorld[] worlds = initGame.getInitPlacementFromPlayers();
		
	}

}
