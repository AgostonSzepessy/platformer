package agoston.platformer.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

import agoston.platformer.Platformer;
import agoston.platformer.managers.GameKeys;

/**
 * Created by Agoston on 2017-01-25.
 */

public class MenuState extends GameState
{
	/**
	 * The title of the game.
	 */
	private final GlyphLayout titleLayout;

	/**
	 * Font for the title of the game.
	 */
	private final BitmapFont titleFont;

	/**
	 * Font for the options in the main menu.
	 */
	private final BitmapFont optionFont;

	/**
	 * The different options the player can choose in the main menu.
	 */
	private final Array<GlyphLayout> optionsLayout;

	/**
	 * Used to render the selector that the player uses to select an option.
	 */
	private final ShapeRenderer shapeRenderer;

	/**
	 * Keeps track of which option the user currently has selected. The counter increases as it goes
	 * downwards the list of options, i.e. "Play" has value 0, and the option below it has 1, etc.
	 */
	private int currentOption;

	/**
	 * The "Play" menu option.
	 */
	private static final int PLAY = 0;
	/**
	 * The QUIT menu option.
	 */
	private static final int QUIT = 1;

	public MenuState(Platformer platformer)
	{
		super(platformer);

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/rayman.ttf"));

		FreeTypeFontGenerator.FreeTypeFontParameter parameter =
				new FreeTypeFontGenerator.FreeTypeFontParameter();

		// setup parameters for the fonts
		parameter.size = screenHeight / 20;
		parameter.color = Color.BLACK;
		parameter.minFilter = Texture.TextureFilter.Linear;
		parameter.magFilter = Texture.TextureFilter.Linear;
		parameter.genMipMaps = true;

		titleFont = generator.generateFont(parameter);
		titleFont.setUseIntegerPositions(true);

		titleLayout = new GlyphLayout(titleFont, "Platformer");

		// the menu options are smaller than the title of the game
		parameter.size *= 0.8;

		optionFont = generator.generateFont(parameter);

		generator.dispose();

		optionsLayout = new Array<GlyphLayout>();
		optionsLayout.add(new GlyphLayout(optionFont, "Play"));
		optionsLayout.add(new GlyphLayout(optionFont, "Quit"));

		camera.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setPosition(camera.viewportWidth / 2, camera.viewportHeight / 2);
		camera.update();

		shapeRenderer = new ShapeRenderer();
	}


	@Override
	public void update(float dt)
	{
		// go downwards on the list of options
		if(GameKeys.isPressed(GameKeys.S) || GameKeys.isPressed(GameKeys.DOWN))
		{
			currentOption++;
		}
		// go upwards on the list of options
		else if(GameKeys.isPressed(GameKeys.W) || GameKeys.isPressed(GameKeys.UP))
		{
			currentOption--;
		}

		if(currentOption >= optionsLayout.size)
		{
			currentOption = 0;
		}
		else if(currentOption < 0)
		{
			currentOption = optionsLayout.size - 1;
		}

		// change state
		if(GameKeys.isPressed(GameKeys.SPACE) || GameKeys.isPressed(GameKeys.ENTER))
		{
			switch(currentOption)
			{
				case PLAY:
					gsm.changeState(new PlayState(platformer));
					break;
				case QUIT:
					Gdx.app.exit();
					break;
			}
		}
	}

	@Override
	public void draw(float dt)
	{
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		titleFont.draw(batch, titleLayout, camera.viewportWidth / 2 - titleLayout.width / 2,
				camera.viewportHeight * 3 / 4);

		// draw the options starting from the middle of the screen, and go downwards
		for(int i = 0; i < optionsLayout.size; ++i)
		{
			optionFont.draw(batch, optionsLayout.get(i),
					camera.viewportWidth / 2 - optionsLayout.get(i).width / 2,
					camera.viewportHeight / 2 - (i * (optionsLayout.get(i).height +
							optionsLayout.get(i).height / 2)));
		}

		batch.end();

		float selectorSize = optionsLayout.get(0).height;

		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setAutoShapeType(true);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		// Find where to draw the selector icon. The selector icon's origin is in the bottom left
		// corner so it's height has to be subtracted from it.
		for(int i = 0; i < optionsLayout.size; ++i)
		{
			if(currentOption == i)
			{
				shapeRenderer.ellipse(camera.viewportWidth / 2 - optionsLayout.get(i).width / 2 -
						selectorSize - selectorSize / 2,
						camera.viewportHeight / 2 - (i * (optionsLayout.get(i).height +
								optionsLayout.get(i).height / 2)) - selectorSize, selectorSize,
						selectorSize);
			}

		}

		shapeRenderer.end();
	}

	@Override
	public void dispose()
	{
		titleFont.dispose();
		optionFont.dispose();
	}
}
