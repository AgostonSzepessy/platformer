package agoston.platformer.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Agoston on 2017-01-25.
 */

public class BoundedCamera extends OrthographicCamera
{
	private float rightXBound;
	private float topYBound;
	private float leftXBound;
	private float bottomYBound;

	/**
	 * Creates a <code>BoundedCamera</code> with a right <code>x</code> boundary of <code>1000</code> and
	 * a top <code>y</code> of <code>1000</code>.
	 */
	public BoundedCamera()
	{
		super();

		setBounds(0, 0, 1000, 1000);
	}

	/**
	 * Creates a <code>BoundedCamera</code> with an <code>rightXBound</code> of <code>1000</code> and
	 * a <code>topYBound</code> of <code>1000</code>, and specified viewport width and viewport height.
	 *
	 * @param viewportWidth Width of the viewport
	 * @param viewportHeight Height of the viewport
	 */
	public BoundedCamera(float viewportWidth, float viewportHeight)
	{
		super(viewportWidth, viewportHeight);
		setBounds(0, 0, 1000, 1000);
	}

	/**
	 * Creates a <code>BoundedCamera</code> with specified values.
	 * @param viewportWidth Width of the viewport
	 * @param viewportHeight Height of the viewport
	 * @param rightXBound The boundary of the camera on the <code>x</code> axis
	 * @param topYBound The boundary of the camera on the <code>y</code> axis
	 */
	public BoundedCamera(float viewportWidth, float viewportHeight, float leftXBound,
						 float rightXBound, float bottomYBound, float topYBound)
	{
		super(viewportWidth, viewportHeight);
		setBounds(leftXBound, bottomYBound, rightXBound, topYBound);
	}

	/**
	 * Sets the boundaries of the camera.
	 * @param leftX the left <code>x</code> axis boundary
	 * @param bottomY the bottom <code>y</code> axis boundary
	 * @param rightX the right <code>x</code> boundary
	 * @param topY the top <code>y</code> boundary
	 */
	public void setBounds(float leftX, float bottomY, float rightX, float topY)
	{
		leftXBound = leftX;
		rightXBound = rightX;
		bottomYBound = bottomY;
		topYBound = topY;
	}

	/**
	 * Checks if the camera is past its bounds and puts it back if it's out of bounds.
	 */
	public void checkBounds()
	{
		// check left x boundary
		if(position.x - viewportWidth / 2 < leftXBound)
		{
			this.position.x = leftXBound;
		}
		// check right boundary
		else if(position.x + viewportWidth / 2 > rightXBound)
		{
			position.x = rightXBound - viewportWidth / 2;
		}

		// check bottom y boundary
		if(position.y - viewportHeight / 2 < bottomYBound)
		{
			position.y = viewportHeight;
		}
		// check top y boundary
		else if(position.y + viewportHeight / 2 > topYBound)
		{
			position.y = topYBound;
		}
	}
}
