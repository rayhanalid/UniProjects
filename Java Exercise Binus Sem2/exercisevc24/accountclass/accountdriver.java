package accountclass;

public class accountdriver
{
    public static void main(String[] args)
    {
        account main = new account("01","rayhan",100);

        //get id
        System.out.println(main.getID());

        //get name
        System.out.println(main.getName());

        //get balance
        System.out.println(main.getBalance());

        //credit
        main.credit(100);

        //debit
        main.debit(400);
        main.debit(50);

        //transfer
        account main2 = new account("02","ali",50);
        main.transferTo(main2, 50);
        System.out.println(main2.getBalance());

        //tostring
        System.out.println(main.toString());
        System.out.println(main2.toString());
    }
};