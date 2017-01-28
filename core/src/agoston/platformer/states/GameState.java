package agoston.platformer.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import agoston.platformer.Platformer;
import agoston.platformer.managers.GameStateManager;
import agoston.platformer.utils.BoundedCamera;

/**
 * Created by Agoston on 2017-01-23.
 */

public abstract class GameState implements Disposable
{
	protected Platformer platformer;
	protected BoundedCamera camera;
	protected SpriteBatch batch;
	protected GameStateManager gsm;

	protected final int screenWidth;
	protected final int screenHeight;

	public GameState(Platformer platformer)
	{
		this.platformer = platformer;
		camera = platformer.getCamera();
		batch = platformer.getBatch();
		gsm  = platformer.getGsm();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
	}

	/**
	 * Updates the game state
	 * @param dt time between frames
	 */
	public abstract void update(float dt);

	/**
	 * Draws the game state
	 * @param dt
	 */
	public abstract void draw(float dt);

	/**
	 * Disposes of the resources held by the current game state.
	 */
	public abstract void dispose();
}
