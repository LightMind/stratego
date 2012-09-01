package visual;

import java.util.concurrent.locks.ReentrantLock;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import standard.Constants;
import standard.StandardWorld;

import framework2.Drawable;
import framework2.Colors;
import framework2.Terrain;
import framework2.Unit;
import framework2.UnitType;
import framework2.World;

public class GameVisualizer implements Drawable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2282524866198223776L;
	private World world;
	private int width = Constants.WIDTH, height = Constants.HEIGHT;
	private int cellSize = Constants.CELLSIZE;
	private int textSize;
	private UnicodeFont uFont;
	private int offsetTextX, offsetTextY;
	private int boxOffset, boxSize;

	private ReentrantLock lock = new ReentrantLock();

	public GameVisualizer() {
		world = new StandardWorld();

		textSize = (cellSize * 2) / 3;
		offsetTextX = cellSize / 3;
		offsetTextY = (cellSize - textSize) / 2;
		boxOffset = cellSize / 8;
		boxSize = (cellSize / 4) - 1;
	}

	@Override
	public void init(GameContainer gc) {
		java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.PLAIN,
				textSize);
		uFont = new UnicodeFont(font);
		uFont.addAsciiGlyphs();
		uFont.getEffects().add(new ColorEffect(java.awt.Color.white));
		try {
			uFont.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void setWorld(World w) {
		lock.lock();
		world = w;
		lock.unlock();
	}

	public void draw(GameContainer gc, Graphics g) {
		lock.lock();
		
		/*
		 * Draw map
		 */
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				Terrain t = world.getTerrain(column, row);
				if (t.equals(Terrain.PLAIN)) {
					g.setColor(Color.decode("#4AA02C"));
				} else {
					g.setColor(Color.decode("#151B8D"));
				}
				g.fillRect(column * cellSize, row * cellSize, cellSize,
						cellSize);

				g.setColor(Color.black);
				g.drawRect(column * cellSize, row * cellSize, cellSize,
						cellSize);
			}
		}

		/*
		 * Draw units
		 */
		g.setFont(uFont);
		
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				Unit unit = world.getUnitAt(column, row);
				if(unit == null){
					continue;
				}
				Colors player = unit.getOwner();
				UnitType type = unit.getType();

				if (!type.equals(UnitType.Empty)) {
					g.setColor(Color.white);
					g.fillRect(column * cellSize + boxOffset, row * cellSize
							+ boxOffset, cellSize - boxSize, cellSize - boxSize);
				} else {
					/*g.setColor(Color.darkGray);
					g.fillRect(column * cellSize + boxOffset, row * cellSize
							+ boxOffset, cellSize - boxSize, cellSize - boxSize);*/
					continue;
				}

				g.setColor(player.getColor());
				g.drawString(type.toString(), column * cellSize + offsetTextX,
						row * cellSize + offsetTextY);
			}
		}
		g.resetFont();
		
		lock.unlock();
	}

}
