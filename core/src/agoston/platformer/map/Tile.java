package agoston.platformer.map;

/**
 * Created by Agoston on 2017-02-11.
 */

public class Tile
{
	private final int size;
	private int type;

	public Tile(int type, int size)
	{
		this.size = size;
		this.type = type;
	}

	public int getSize()
	{
		return size;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}
}
