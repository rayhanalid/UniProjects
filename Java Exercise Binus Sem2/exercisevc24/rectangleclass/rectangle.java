package rectangleclass;

public class rectangle
{
    private float length;
    private float width;

    public rectangle()
    {
        this.length = 1.0f;
        this.width = 1.0f;
    }

    public rectangle(float length, float width)
    {
        if (length > 0 && width > 0)
        {
            this.length = length;
            this.width = width;
        }
        else
        {
            this.length = 1.0f;
            this.width = 1.0f;
        }
    }

    public float getLength()
    {
        return this.length;
    }

    public void setLength(float length)
    {
        if (length > 0)
        {
            this.length = length;
        }
        else
        {
            this.length = 1.0f;
        }
    }

    public float getWidth()
    {
        return this.width;
    }

    public void setWidth(float width)
    {
        if (width > 0)
        {
            this.width = width;
        }
        else
        {
            this.width = 1.0f;
        }
    }

    public double getArea()
    {
        return (this.width*this.length);
    }

    public double getPerimeter()
    {
        return ((this.width*2) + (this.length*2));
    }

    @Override
    public String toString()
    {
        return "Rectangle [length =" + length + " , width =" + width + "]";
    }

};