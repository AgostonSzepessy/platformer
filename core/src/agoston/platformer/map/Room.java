package agoston.platformer.map;

import com.badlogic.gdx.utils.Array;

/**
 * A {@link Room} contains a section of the level; several rooms are put together to make up the
 * final layout of the {@link Level}. It is used during the generation of the {@link Level}.
 */
public class Room
{
	/**
	 * The height of the room in tiles; number of tiles high.
	 */
	private final int height;

	/**
	 * The width of the room in tiles; number of tiles across.
	 */
	private final int width;

	private Array<Array<Tile>> tiles;

	public Room(int height, int width)
	{
		this.height = height;
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}
}
