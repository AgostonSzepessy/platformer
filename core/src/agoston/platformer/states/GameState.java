package agoston.platformer.states;

import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Agoston on 2017-01-23.
 */

public abstract class GameState implements Disposable
{
	public GameState()
	{
		
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
