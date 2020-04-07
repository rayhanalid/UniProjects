package Banking;



public class Driver

{

    public static void main(String[] args)

    {

        Account z1 = new Account(100);

        Account z2 = new Account(50);



        z1.deposit(100);

        z2.deposit(100);



        Customer k1 = new Customer("Ali", "Ray");

        Customer k2 = new Customer("Den","ver");



        k1.setAccount(z1);

        

        Bank g1 = new Bank("HSBC");

        System.out.println(g1.getNumOfCustomers());



        g1.addCustomer(k1);

        g1.addNewCustomer("Tok", "Yo");

        g1.addCustomer(k2);



        System.out.println(g1.getNumOfCustomers());



        System.out.println(g1.getCustomer(2));



        System.out.println(g1.getAllCustomers());







    }

