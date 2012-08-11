package standard.client;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.SlickException;


public class ClientApplication {

	/**
	 * @param args
	 * @throws SlickException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SlickException, ClassNotFoundException, IOException, InterruptedException {
		Game game = new ClientGame("Stratego", "localhost");
		AppGameContainer gc = new AppGameContainer(game, 800, 600, false);
		gc.setTargetFrameRate(60);
		gc.setAlwaysRender(true);
		gc.setUpdateOnlyWhenVisible(false);
		gc.start();

	}

}
