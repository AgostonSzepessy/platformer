package agoston.platformer.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Agoston on 2017-01-26.
 */

public class ResourceManager implements Disposable
{
	private HashMap<String, TextureAtlas> textureManager;

	public ResourceManager()
	{
		textureManager = new HashMap<String, TextureAtlas>();
	}

	public void loadAtlas(String name)
	{
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(name));

		textureManager.put(name, atlas);
	}

	public TextureRegion getRegion(String atlasName, String regionName)
	{
		return textureManager.get(atlasName).findRegion(regionName);
	}

	@Override
	public void dispose()
	{
		for(String key : textureManager.keySet())
		{
			textureManager.get(key).dispose();
		}
	}
}
