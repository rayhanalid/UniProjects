package invoiceclass;

public class invoicedriver
{
    public static void main(String[] args)
    {
        invoiceitem main = new invoiceitem("01","food",10,5.50);

        //get id
        System.out.println(main.getID());

        //get desc
        System.out.println(main.getDesc());

        //get qty
        System.out.println(main.getQty());

        //set qty
        main.setQty(20);

        //get unitprice
        System.out.println(main.getUnitPrice());

        //set unitprice
        main.setUnitPrice(6.10);

        //get total
        System.out.println(main.getTotal());

        //TOSTRING
        System.out.println(main.toString());
    }
};