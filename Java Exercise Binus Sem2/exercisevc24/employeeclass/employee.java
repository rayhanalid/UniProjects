package employeeclass;

public class employee
{
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public employee(int id, String firstName, String lastName, int salary)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getID()
    {
        return this.id;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getFullName()
    {
        return this.firstName + " " + this.lastName;
    }

    public int getSalary()
    {
        return this.salary;
    }

    public void setSalary(int salary)
    {
        if (salary >= 0)
        {
            this.salary = salary;
            System.out.println("Set salary : " + this.salary);
        }
        else
        {
            System.out.println("Invalid salary!");
        }
    }

    public int getAnnualSalary()
    {
        return this.salary * 12;
    }

    public int raiseSalary(int percent)
    {
        salary = salary + (salary * percent) / 100;
        return salary;
    }

    @Override
    public String toString()
    {
        return "Employee[id=" + id + ",name=" + firstName + " " + lastName + ",salary=" + salary + "]"; 
    }
    
};