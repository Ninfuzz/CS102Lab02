/*

* @author (Dylan I. Pace)

* <p> (File Name)

* <p> (Assignment)

* <p> (Describe, in general, the code contained.)

*/

/**
 * @author Ninfuzz
 *
 */
public class Rectangle
{
	
	private int width;
	private int height;
	
	public Rectangle (int width, int height)
	{
		this.width = width;
		this.height = height;
		
	}
	
	public void setWidth (int width)
	{
		if (width < 64)
		{
			this.width = width;
		}
	}
	
	public void setHeight (int height)
	{
		this.height = height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void draw()
	{
		for (int c = 0; c < height; c++)
		{
			for (int i = 0; i < width; i++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
