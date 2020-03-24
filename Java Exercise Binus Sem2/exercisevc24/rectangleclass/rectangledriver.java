package rectangleclass;

public class rectangledriver
{
    public static void main (String[] args)
    {
        //Default 
        rectangle main = new rectangle();
        System.out.println(main.toString());

        //Parameter
        rectangle main2 = new rectangle(1.0f,2.0f);
        System.out.println(main2.toString());

        //Set Length Width
        main2.setLength(3.0f);
        main2.setWidth(5.0f);
        
        //Get Length Width
        System.out.println("Length = " + main2.getLength());
        System.out.println("Width = " + main2.getWidth());

        //Get Area
        System.out.println("Area = " + main2.getArea());

        //Get Perimeter
        System.out.println("Perimeter = " + main2.getPerimeter());

        //To String
        System.out.println(main2.toString());


    }
    

    

};