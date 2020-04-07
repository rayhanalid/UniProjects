
package Banking;

ArrayList;
public class Bank {

    private

        ArrayList<Customer> customers = new ArrayList<Customer>();

        int numberOfCustomers;

        String bankName;



    public

        Bank(String bName)

        {

            this.bankName = bName;

            this.numberOfCustomers = customers.size();

        }



        void addCustomer(Customer customer)

        {

            this.customers.add(customer);

        }



        void addNewCustomer(String f, String l)

        {

            this.customers.add(new Customer(f, l));

        }

        int getNumOfCustomers()

        {

            this.numberOfCustomers = customers.size();

            return this.numberOfCustomers;

        }



        Customer getCustomer(int index)

        {

            if(customers.size() > index)

            {

                return customers.get(index);

            }



            else

            {

                return null;

            }



        }

        String getAllCustomers()

        {

            String out = "";

            for(int i = 0; i < this.customers.size(); i++)

            {

                out += customers.get(i) + ", ";

            }



            return out;



        }






}