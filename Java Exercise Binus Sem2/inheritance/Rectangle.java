package assignments.inheritance;

public class Rectangle extends Shape
{
	private double width, length;

	public Rectangle()
	{
		super();
		this.width = 1.0d;
		this.length = 1.0d;
	}
	public Rectangle(double length, double width)
	{
		super();
		this.width = width;
		this.length = length;
	}
	public Rectangle(double length, double width, String color, boolean filled)
	{
		super(color, filled);
		this.width = width;
		this.length = length;
	}
	
	public double getWidth()
	{
		return width;
	}
	public void setWidth(double width)
	{
		this.width = width;
	}
	public double getLength() 
	{
		return length;
	}
	public void setLength(double length) 
	{
		this.length = length;
	}

	public double getArea()
	{
		return this.getWidth() * this.getLength();
	}
	public double getPerimeter()
	{
		return 2d + this.getWidth() * this.getLength();
	}
	
	@Override
	public String toString()
	{
		return "A Rectangle  with width = " + Double.toString(this.getWidth()) + " and length = " + Double.toString(this.getLength()) + ", which is a subclass of " + super.toString();
	}
}
