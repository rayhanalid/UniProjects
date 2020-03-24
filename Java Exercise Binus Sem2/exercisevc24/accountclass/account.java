package accountclass;

public class account
{
    private String id;
    private String name;
    private int balance;

    public account(String id, String name)
    {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public account(String id, String name, int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getID()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getBalance()
    {
        return this.balance;
    }

    public int credit(int amount)
    {
        if (amount > 0)
        {
            balance += amount;
        }
        return balance;
    }

    public int debit(int amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
        }

        else
        {
            System.out.println("Amount exceeded balance");
        }

        return balance;
    }

    public int transferTo(account another, int amount)
    {
        if(amount <= balance)
        {
            this.balance -= amount;
            another.balance += amount;
        }

        else
        {
            System.out.println("Balance isn't Enough");
        }

        return balance;
    }

    @Override
    public String toString()
    {
        return "Account[id=" + id + ",name=" + name + ",balance=" + balance + "]";
    }

    


}