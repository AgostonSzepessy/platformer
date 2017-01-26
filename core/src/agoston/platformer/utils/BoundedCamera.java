package agoston.platformer.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Agoston on 2017-01-25.
 */

public class BoundedCamera extends OrthographicCamera
{
	private float xBound;
	private float yBound;

	public BoundedCamera()
	{
		super();

		setBounds(1000, 1000);
	}

	public BoundedCamera(float viewportWidth, float viewportHeight)
	{
		super(viewportWidth, viewportHeight);
		setBounds(1000, 1000);
	}

	public BoundedCamera(float viewportWidth, float viewportHeight, float xBound, float yBound)
	{
		super(viewportWidth, viewportHeight);
		setBounds(xBound, yBound);
	}

	public void setBounds(float x, float y)
	{
		xBound = x;
		yBound = y;
	}

	public void checkBounds()
	{
		if(this.position.x < 0)
		{
			this.position.x = 0;
		}
		else if(this.position.x > xBound)
		{
			this.position.x = xBound - this.viewportWidth / 2;
		}
		if(this.position.y < 0)
		{
			this.position.y = this.viewportHeight;
		}
		else if(this.position.y > this.yBound)
		{
			this.position.y = this.yBound;
		}
	}
}
