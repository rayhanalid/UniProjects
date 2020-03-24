package dateclass;

public class datedriver
{
    public static void main(String[] args)
    {
        date main = new date(24,3,2020);
        
        //get date
        System.out.println(main.getDay());

        //get month
        System.out.println(main.getMonth());

        //get year
        System.out.println(main.getYear());

        //set day
        main.setDay(20);

        //set month
        main.setMonth(40);

        //set year
        main.setYear(2012);

        //set date
        main.setDate(2,4,2002);

        //tostring
        System.out.println(main.toString());
        
    }
};