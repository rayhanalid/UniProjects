
package Banking;
public class Customer {
    private

    String firstName;

    String lastName;

    Account account;



public Customer(String f, String l)

{

    this.firstName = f;

    this.lastName = l;

}



public String getFirstName()

{

    return this.firstName;

}



public String getLastName()

{

    return this.lastName;

}
public Account getAccount()

    {

        return this.account;

    }



    public void setAccount(Account acct)

    {

        this.account = acct;

    }



    public String toString()

    {

        return "Account[Fullname = " + getFirstName() + " " + getLastName() + "]";

    }






}