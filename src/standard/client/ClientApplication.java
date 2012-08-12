package standard.client;

import java.io.IOException;

import javax.swing.JOptionPane;

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
		String s = (String)JOptionPane.showInputDialog("port please");
		int port = Integer.parseInt(s);
		Game game = new ClientGame("Stratego", "localhost", port);
		AppGameContainer gc = new AppGameContainer(game, 800, 600, false);
		gc.setTargetFrameRate(60);
		gc.setAlwaysRender(true);
		gc.setUpdateOnlyWhenVisible(false);
		gc.start();

	}

}
