package dateclass;



public class date
{
    private int day;
    private int month;
    private int year;

    public date(int day, int month, int year)
    {
        if(day >= 1 && day <= 31)
        {
            if(month >= 1 && month <= 12)
            {
                if(year >= 1900 && year <= 9999)
                {
                    this.day = day;
                    this.month = month;
                    this.year = year;
                }
            }
        }

        
        

    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public void setDay(int day)
    {
        if (day >= 1 && day <= 31)
        {
            this.day = day;
        }
    }

    public void setMonth(int month)
    {
        if (month >= 1 && month <= 12)
        {
            this.month = month;
        }
    }

    public void setYear(int year)
    {
        if (year >= 1900 && year <= 9999)
        {
            this.year = year;
        }
    }

    public void setDate(int day,int month, int year)
    {
        if (day >= 1 && day <= 31)
        {
            if (month >= 1 && month <= 12)
            {
                if (year >= 1900 && year <= 9999)
                {
                    this.day = day;
                    this.month = month;
                    this.year = year;
                }
            }
        }
    }

    public String toString()
    {
        if(day < 10)
        {
            if (month < 10)
            {
                return "0" + day + "/" + "0" + month + "/" + year;
            }

            else
            {
                return "0" + day + "/" + month + "/" + year;
            }

        }

        else
        {
            if (month < 10)
            {
                return day + "/" + "0" + month + "/" + year;
            }

            else
            {
                return day + "/" + month + "/" + year;
            }
        }

    }

}