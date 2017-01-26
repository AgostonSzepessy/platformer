package agoston.platformer.managers;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import agoston.platformer.states.GameState;

/**
 * Created by Agoston on 2017-01-23.
 */

public class GameStateManager implements Disposable
{
	/**
	 * Stack that holds the different game states that the game can have. E.g. Main menu and play
	 * state.
	 */
	private Deque<GameState> states;

	/**
	 * Holds the state to transfer to when pushState() and changeState() are called.
	 */
	private GameState tempState;

	private boolean changingState;
	private boolean pushingState;
	private boolean poppingState;

	public GameStateManager()
	{
		states = new ArrayDeque<GameState>();
	}

	public void pushState(GameState state)
	{
		pushingState = true;
		tempState = state;
	}

	public void popState()
	{
		poppingState = true;
	}

	public void changeState()
	{
		changingState = true;
	}

	/**
	 * Updates the current game state.
	 * @param dt time between frames
	 */
	public void update(float dt)
	{
		if(poppingState)
		{
			states.pop();
			poppingState = false;
		}
		if(pushingState)
		{
			states.push(tempState);
			tempState = null;
			pushingState = false;
		}
		if(changingState)
		{
			states.pop();
			changingState = false;
			tempState = null;
		}

		states.peek().update(dt);
	}

	/**
	 * Draws the current game state
	 * @param dt time between frames
	 */
	public void draw(float dt)
	{
		states.peek().draw(dt);
	}

	/**
	 * Disposes of the resources held by the current game state.
	 */
	@Override
	public void dispose()
	{
		states.peek().dispose();
	}
}
