package agoston.platformer.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import agoston.platformer.Platformer;

/**
 * Created by Agoston on 2017-01-25.
 */

public class MenuState extends GameState
{
	private final BitmapFont titleFont;
	private final GlyphLayout titleLayout;
	private BitmapFont optionFont;

	public MenuState(Platformer platformer)
	{
		super(platformer);

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/rayman.ttf"));

		FreeTypeFontGenerator.FreeTypeFontParameter parameter =
				new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameter.size = screenHeight / 20;
		parameter.color = Color.BLACK;
		parameter.minFilter = Texture.TextureFilter.Linear;
		parameter.magFilter = Texture.TextureFilter.Linear;
		parameter.genMipMaps = true;

		titleFont = generator.generateFont(parameter);
		titleFont.setUseIntegerPositions(true);

		titleLayout = new GlyphLayout(titleFont, "Platformer");

		generator.dispose();

		camera.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setPosition(camera.viewportWidth / 2, camera.viewportHeight / 2);
		camera.update();

		System.out.println(camera.viewportHeight);
	}

	@Override
	public void update(float dt)
	{

	}

	@Override
	public void draw(float dt)
	{
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		titleFont.draw(batch, titleLayout, camera.viewportWidth / 2 - titleLayout.width / 2, camera.viewportHeight * 3 / 4);
		batch.end();
	}

	@Override
	public void dispose()
	{
		titleFont.dispose();
	}
}
