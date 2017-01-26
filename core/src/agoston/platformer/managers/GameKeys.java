package agoston.platformer.managers;

/**
 * Created by Agoston on 2017-01-25.
 */

public class GameKeys
{
	/**
	 * The A key
	 */
	public static final int A = 0;

	/**
	 * The D key
	 */
	public static final int D = 1;

	/**
	 * The S key
	 */
	public static final int S = 2;

	/**
	 * The W key
	 */
	public static final int W = 3;

	/**
	 * The Q key
	 */
	public static final int Q = 4;

	/**
	 * The E key
	 */
	public static final int E = 5;

	/**
	 * The F key
	 */
	public static final int F = 6;

	/**
	 * The R key
	 */
	public static final int R = 7;

	/**
	 * The Escape key
	 */
	public static final int ESCAPE = 8;

	/**
	 * The Space key
	 */
	public static final int SPACE = 9;

	/**
	 * The Enter key
	 */
	public static final int ENTER = 10;

	/**
	 * The Left Arrow key
	 */
	public static final int LEFT = 11;

	/**
	 * The Right Arrow key
	 */
	public static final int RIGHT = 12;

	/**
	 * The Up Arrow key
	 */
	public static final int UP = 13;

	/**
	 * The Down Arrow key
	 */
	public static final int DOWN = 14;

	private static final int NUM_KEYS = 15;

	private static boolean[] prevKeys = new boolean[NUM_KEYS];
	private static boolean[] currentKeys = new boolean[NUM_KEYS];

	public static void update()
	{
		System.arraycopy(currentKeys, 0, prevKeys, 0, NUM_KEYS);
	}

	public static void setKey(int key, boolean pressed)
	{
		currentKeys[key] = pressed;
	}

	/**
	 * The key press triggers only once, even if the key is held down. Once the key is let go of and
	 * pressed again, it will return true.
	 * @param keycode Key to check
	 * @return <code>true</code> if the key was not pressed last frame and is pressed this frame
	 */
	public static boolean isPressed(int key)
	{
		return !prevKeys[key] && currentKeys[key];
	}

	/**
	 * Checks if the key specified is held down.
	 * @param keycode Key to check
	 * @return true if the key is held down
	 */
	public static boolean isDown(int key)
	{
		return currentKeys[key];
	}
}
