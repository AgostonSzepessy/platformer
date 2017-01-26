package agoston.platformer.managers;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

/**
 * Created by Agoston on 2017-01-25.
 */

public class InputManager extends InputAdapter
{
	public InputManager()
	{
		super();
	}

	@Override
	public boolean keyUp(int keycode)
	{
		switch(keycode)
		{
			case Keys.A:
				GameKeys.setKey(GameKeys.A, false);
				break;
			case Keys.D:
				GameKeys.setKey(GameKeys.D, false);
				break;
			case Keys.E:
				GameKeys.setKey(GameKeys.E, false);
				break;
			case Keys.S:
				GameKeys.setKey(GameKeys.S, false);
				break;
			case Keys.W:
				GameKeys.setKey(GameKeys.W, false);
				break;
			case Keys.R:
				GameKeys.setKey(GameKeys.R, false);
				break;
			case Keys.F:
				GameKeys.setKey(GameKeys.F, false);
				break;
			case Keys.LEFT:
				GameKeys.setKey(GameKeys.LEFT, false);
				break;
			case Keys.RIGHT:
				GameKeys.setKey(GameKeys.RIGHT, false);
				break;
			case Keys.UP:
				GameKeys.setKey(GameKeys.UP, false);
				break;
			case Keys.DOWN:
				GameKeys.setKey(GameKeys.DOWN, false);
				break;
			case Keys.ESCAPE:
				GameKeys.setKey(GameKeys.ESCAPE, false);
				break;
			case Keys.ENTER:
				GameKeys.setKey(GameKeys.ENTER, false);
				break;
			case Keys.SPACE:
				GameKeys.setKey(GameKeys.SPACE, false);
				break;
		}

		return true;
	}

	@Override
	public boolean keyDown(int keycode)
	{
		switch(keycode)
		{
			case Keys.A:
				GameKeys.setKey(GameKeys.A, true);
				break;
			case Keys.D:
				GameKeys.setKey(GameKeys.D, true);
				break;
			case Keys.E:
				GameKeys.setKey(GameKeys.E, true);
				break;
			case Keys.S:
				GameKeys.setKey(GameKeys.S, true);
				break;
			case Keys.W:
				GameKeys.setKey(GameKeys.W, true);
				break;
			case Keys.R:
				GameKeys.setKey(GameKeys.R, true);
				break;
			case Keys.F:
				GameKeys.setKey(GameKeys.F, true);
				break;
			case Keys.LEFT:
				GameKeys.setKey(GameKeys.LEFT, true);
				break;
			case Keys.RIGHT:
				GameKeys.setKey(GameKeys.RIGHT, true);
				break;
			case Keys.UP:
				GameKeys.setKey(GameKeys.UP, true);
				break;
			case Keys.DOWN:
				GameKeys.setKey(GameKeys.DOWN, true);
				break;
			case Keys.ESCAPE:
				GameKeys.setKey(GameKeys.ESCAPE, true);
				break;
			case Keys.ENTER:
				GameKeys.setKey(GameKeys.ENTER, true);
				break;
			case Keys.SPACE:
				GameKeys.setKey(GameKeys.SPACE, true);
				break;
		}

		return true;
	}
}
