// Rayhan Ali Darmawan - 2301891683

// Programming Language - Array Exercise



import java.util.Arrays;

import java.util.ArrayList;

import java.util.Scanner;



// No. 1



public class ArrayExercise

{

    public static void main(String[] args)

    {

        ArrayExercise caller = new ArrayExercise();



        // Un-comment to run function



        caller.one();

        // caller.two();

        // caller.three();

        // caller.four();

        // caller.five();

        // caller.six();

        // caller.seven();

        // caller.eight();

        // caller.nine();

        // caller.ten();



    }  



    public void one()

    {

        Scanner sc = new Scanner(System.in);

        

        int intArray[] = new int[10];

        

        System.out.println("Enter 10 digits separated by the enter key : ");

        

        for(int i = 0;i < intArray.length;i++)

        {

            intArray[i] = sc.nextInt();

        }



        System.out.println("Your Array : " + Arrays.toString(intArray));



        sc.close();

    }



    public void two()

    {

        Scanner sc = new Scanner(System.in);

        

        int intArray[] = new int[10];

        

        System.out.println("Enter 10 digits separated by the enter key : ");

        

        for(int i = 0;i < intArray.length;i++)

        {

            intArray[i] = sc.nextInt();

        }



        System.out.print("Enter a number to check : ");

        int check = sc.nextInt();

        boolean available = false;

        for (int i = 0; i < intArray.length; i++)

        {

            if(intArray[i] == check)

            {

                available = true;

                break;

            }

    

        }

        if(available == true)

        {

            System.out.println(check + " is in the array!");

        }

        

        else

        {

            System.out.println(check + " is not in the array.");

        }



        sc.close();

    }



    public void three()

    {

        Scanner sc = new Scanner(System.in);

        

        int intArray[] = new int[20];

        int counter = 0;

        System.out.println("Enter 20 digits separated by the enter key : ");

        

        for(int i = 0;i < 20; i++)

        {

            intArray[i] = sc.nextInt();

        }



        System.out.println("Positive: ");

        for(int i=0;i < 20; i++)

        {

            if(intArray[i] > 0)

            {

                System.out.print(intArray[i] + " ");

                counter++;

            }



        }

        System.out.println("\nNumber of Positives: " + counter);



        counter = 0;

        System.out.println("\nNegative: ");

        for(int i=0;i < 20; i++)

        {

            if(intArray[i] < 0)

            {

                System.out.print(intArray[i] + " ");

                counter++;

            }



        }

        System.out.println("\nNumber of Negatives: " + counter);

        

        counter = 0;

        System.out.println("\nOdd: ");

        for(int i=0;i < 20; i++)

        {

            if(intArray[i] % 2 == 1 | intArray[i] % 2 == -1)

            {

                System.out.print(intArray[i] + " ");

                counter++;

            }



        }

        System.out.println("\nNumber of Odd: " + counter);



        counter = 0;

        System.out.println("\nEven: ");

        for(int i=0;i < 20; i++)

        {

            if(intArray[i] % 2 == 0 )

            {

                System.out.print(intArray[i] + " ");

                counter++;

            }



        }

        System.out.println("\nNumber of Even: " + counter);



        counter = 0;

        System.out.println("\nZeroes: ");

        for(int i=0;i < 20; i++)

        {

            if(intArray[i] == 0)

            {

                System.out.print(intArray[i] + " ");

                counter++;

            }



        }

        System.out.println("\nNumber of Zeroes: " + counter);

        sc.close();

    }



    public void four()

    {

        Scanner sc = new Scanner(System.in);

        

        int intArray[] = new int[10];

        

        System.out.println("Enter 10 digits separated by the enter key : ");

        

        for(int i = 0;i < intArray.length; i++)

        {

            intArray[i] = sc.nextInt();

        }



        int sum = 0;

        int product = 1;



        for (int i = 0; i<intArray.length;i++)

        {

            sum += intArray[i];

            product *= intArray[i];

        }



        System.out.println("Sum of the array is : " + sum);



        System.out.println("Product of the array is : " + product);



        sc.close();

    }



    public void five()

    {

        Scanner sc = new Scanner(System.in);

        

        int intArray[] = new int[10];

        

        System.out.println("Enter 10 digits separated by the enter key : ");

        

        for(int i = 0;i < intArray.length; i++)

        {

            intArray[i] = sc.nextInt();

        } 



        System.out.println("Your Array : " + Arrays.toString(intArray));



        Arrays.sort(intArray);

        

        System.out.println("Lowest number : " + intArray[0]);

        System.out.println("Highest number: " + intArray[9]);





        sc.close();

    }



    public void six()

    {

        Scanner sc = new Scanner(System.in);

        

        int intArray[] = new int[10];

        int reversed[] = new int[10];

        boolean palindrome = false;

        

        System.out.println("Enter 10 digits separated by the enter key : ");

        

        for(int i = 0;i < 10; i++)

        {

            intArray[i] = sc.nextInt();

        }



        System.out.println("Array : " + Arrays.toString(intArray)); 

        for(int j = 0; j < intArray.length; j++)

        {

            reversed[intArray.length-1-j] = intArray[j];

        }



        for(int k = 0; k < intArray.length; k++)

        {

            if(intArray[k] == reversed[k])

            {

                palindrome = true;

            }



            else

            {

                break;

            }

        }



        if (palindrome == true)

        {

            System.out.println("Palindrome");

        }

        

        else

        {

            System.out.println("Not Palindrome");

        }

        



        System.out.println("Array : " + Arrays.toString(reversed));



        sc.close();



    }



    public void seven()

    {

        Scanner sc = new Scanner(System.in);

    

        int intArray[] = new int[10];

        

        System.out.println("Enter 10 digits separated by the enter key : ");

        

        for(int i = 0;i < intArray.length; i++)

        {

            intArray[i] = sc.nextInt();

        }



        System.out.println(Arrays.toString(intArray));



        int[] firstHalf = Arrays.copyOf(intArray,5);

        int[] secondHalf = Arrays.copyOfRange(intArray,5,10);

        



        System.out.println(Arrays.toString(firstHalf));

        System.out.println(Arrays.toString(secondHalf));



        sc.close();

    }



    public void eight()

    {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(4);

        numbers.add(8);

        numbers.add(6);

        numbers.add(3);

        numbers.add(2);



        System.out.println(numbers);

        int nextMax = 0;

        int max = 0;

        for(int i = 0; i < (numbers.size()-1); i++)

        {

            if(numbers.get(i) > max)

            {

                max = numbers.get(i);

            }



        }



        for (int j = 0; j < numbers.size()-1; j++)

        {

            if (numbers.get(j) > nextMax)

            {

                if (numbers.get(j) != max)

                {

                    nextMax = numbers.get(j);

                }

            }

        }



        for (int k = 0; k < numbers.size(); k++)

        {

            if(numbers.get(k) == max)

            {

                System.out.print(nextMax + " " + (max-nextMax) + " ");

            }



            else

            {

                System.out.print(numbers.get(k) + " ");

            }

        }

        

        

    }



    public void nine()

    {        

        int intArray[] = {1,2,3,4,5};

        int temp;



        System.out.println("Array : " + Arrays.toString(intArray));

        for(int i = 1;i < intArray.length;i++)

        {

            temp = intArray[i];

            intArray[i] = intArray[0];

            intArray[0] = temp;



        }



        System.out.println("Array after shift : " + Arrays.toString(intArray));



       

    }



    public void ten()

    {   

        int intArray[] = {4,2,1,5,6};



        System.out.println("Before sorting : " + Arrays.toString(intArray));



        Arrays.sort(intArray);



        System.out.println("After sorting : " + Arrays.toString(intArray));



    }



}