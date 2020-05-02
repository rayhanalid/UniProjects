package assignments.inheritance;

public class Circle extends Shape
{

	private double radius;

	public Circle()
	{
		super();
		this.radius = 1.0;
	}
	public Circle(double radius)
	{
		super();
		this.radius = radius;
	}
	public Circle(double radius, String color, boolean filled)
	{
		super(color, filled);
		this.radius = radius;
	}
	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public double getArea()
	{
		return Math.PI * Math.pow(this.getRadius(), 2);
	}
	public double getPerimeter()
	{
		return 2d * Math.PI * this.getRadius();
	}

	@Override
	public String toString()
	{
		return "A Circle with radius " + Double.toString(this.getRadius()) + ", which is a subclass of " + super.toString();
	}
}
