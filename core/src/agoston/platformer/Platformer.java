package agoston.platformer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import agoston.platformer.managers.GameKeys;
import agoston.platformer.managers.GameStateManager;
import agoston.platformer.managers.InputManager;
import agoston.platformer.states.MenuState;
import agoston.platformer.utils.BoundedCamera;

public class Platformer extends ApplicationAdapter
{
	private SpriteBatch batch;
	private BoundedCamera camera;
	private GameStateManager gsm;

	@Override
	public void create () {
		batch = new SpriteBatch();

		camera = new BoundedCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		gsm = new GameStateManager();
		gsm.pushState(new MenuState(this));

		System.out.println(Gdx.graphics.getWidth());

		Gdx.input.setInputProcessor(new InputManager());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw(Gdx.graphics.getDeltaTime());

		GameKeys.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gsm.dispose();
	}

	public BoundedCamera getCamera()
	{
		return camera;
	}

	public SpriteBatch getBatch()
	{
		return batch;
	}

	public GameStateManager getGsm()
	{
		return gsm;
	}
}
