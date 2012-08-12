package standard.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import framework2.Player;

import standard.UserPlayer;
import visual.GameVisualizer;

public class ClientGame extends BasicGame {

	private GameVisualizer visual;
	private NetworkClient client;
	private UserPlayer player;
	
	public ClientGame(String title, String addString, int port) throws ClassNotFoundException, IOException, InterruptedException {
		super(title);
		visual = new GameVisualizer();
		player = new UserPlayer(visual);
		
		InetAddress sad = new InetSocketAddress(addString, port).getAddress();
		client = new NetworkClient(sad, port, player);
		
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		visual.draw(container, g);
		player.draw(container, g);

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		visual.init(container);
		client.start();

	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		player.update(container, delta);

	}

}
