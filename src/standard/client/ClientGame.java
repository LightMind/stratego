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
	private Player player;
	
	public ClientGame(String title, String addString) throws ClassNotFoundException, IOException, InterruptedException {
		super(title);
		visual = new GameVisualizer();
		player = new UserPlayer(visual);
		
		InetAddress sad = new InetSocketAddress(addString, 25565).getAddress();
		client = new NetworkClient(sad, 25565, player);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		// TODO Auto-generated method stub

	}

}
