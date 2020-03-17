// Rayhan Ali Darmawan - 2301891683



package march17vc;





//IMPORTS

import java.util.Arrays;

import java.util.ArrayList;



//Methods



public class utility

{

    public void one()

    {

        //Initializing arraylist

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(4);

        numbers.add(8);

        numbers.add(6);

        numbers.add(3);

        numbers.add(2);



        //Printing current Array

        System.out.println("Current Array : " + numbers);



        int nextMax = 0;

        int max = 0;



        // Finding largest value

        for(int i = 0; i < (numbers.size()-1); i++)

        {

            if(numbers.get(i) > max)

            {

                max = numbers.get(i);

            }



        }



        // Finding next largest value

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

        

        // Printing array after split

        System.out.print("Array after split: ");

        for (int k = 0; k < numbers.size(); k++)

        {

            if(numbers.get(k) == max)

            {

                //splitting highest value to the next highest value + required additive

                System.out.print(nextMax + " " + (max-nextMax) + " ");

            }



            else

            {

                System.out.print(numbers.get(k) + " ");

            }

        }

    }



    public void two(int rot)

    {

        // Initializing array and temp variable

        int array[] = {1,2,3,4,5};

        int temp;



        //printing array

        System.out.println("Array : " + Arrays.toString(array));



        //Rotation for loop

        for (int j = 1; j <= rot;j++)

        {

            for(int i = 1;i < array.length;i++)

            {

                temp = array[i];

                array[i] = array[0];

                array[0] = temp;

    

            }

        }

        

        //printing array after rotation

        System.out.println("Array after shift : " + Arrays.toString(array));

    }



    public boolean symmetric(int matrix[][], int n)

    {

        for (int i = 0; i < n; i++)

        {

            for (int j = 0; j < n; j++)

            {

                if (matrix[i][j] != matrix[j][i])

                {

                    return false;

                }

            }

        }

        return true;

    }



    public void oddMagicSquare(int n)

    {

        int[][] magicSquare = new int[n][n]; 

          

        // Initializing position for 1

        int i = n/2; 

        int j = n-1; 

   

        // Inserting all values of magic square



        for (int num=1; num <= n*n; ) 

        { 

            // Third condition = if 

            if (i==-1 && j==n)

            { 

                j = n-2; 

                i = 0; 

            } 

            else

            { 

                //1st condition helper if next number  

                // goes to out of square's right side 

                if (j == n) 

                    j = 0; 

                      

                //1st condition helper if next number is  

                // goes to out of square's upper side 

                if (i < 0) 

                    i=n-1; 

            } 

              

            //2nd condition 

            if (magicSquare[i][j] != 0)  

            { 

                j -= 2; 

                i++; 

                continue; 

            } 

            else

                //set number 

                magicSquare[i][j] = num++;  

                  

            //1st condition 

            j++;  i--;  

        } 
         // print magic square 

         System.out.println("The Magic Square for "+n+":"); 

         System.out.println("Sum of each row or column "+n*(n*n+1)/2+":"); 
 
         for(i=0; i<n; i++) 
 
         { 
 
             for(j=0; j<n; j++) 
 
                 System.out.print(magicSquare[i][j]+" "); 
 
             System.out.println(); 
 
         } 
 
     }
 
 
 
     public void evenMagicSquare(int n)
 
     {
 
         int[][] arr = new int[n][n];
 
         int i , j;
 
 
 
         //filing matrix with count value from 1
 
         for (i  = 0; i < n; i++)
 
         {
 
             for (j =0 ; j<n;j++)
 
             {
 
                 arr[i][j] = (n*i) + j + 1;
 
             }
 
         }
 
 
 
         //change value of array elements
 
         // (order (n/4)*(n/4)) 
 
         for ( i = 0; i < n/4; i++) 
 
             for ( j = 0; j < n/4; j++) 
 
                 arr[i][j] = (n*n + 1) - arr[i][j]; 
 
       
 
         // Top Right corner of Matrix  
 
         for ( i = 0; i < n/4; i++) 
 
             for ( j = 3 * (n/4); j < n; j++) 
 
                 arr[i][j] = (n*n + 1) - arr[i][j]; 
 
        
 
 
 
         // Bottom Left corner of Matrix 
 
         for ( i = 3 * n/4; i < n; i++) 
 
             for ( j = 0; j < n/4; j++) 
 
                 arr[i][j] = (n*n+1) - arr[i][j]; 
 
       
 
         // Bottom Right corner of Matrix  
 
         for ( i = 3 * n/4; i < n; i++) 
 
             for ( j = 3 * n/4; j < n; j++) 
 
                 arr[i][j] = (n*n + 1) - arr[i][j]; 
 
      
 
     
 
         // Centre of Matrix (order (n/2)*(n/2)) 
 
         for ( i = n/4; i < 3 * n/4; i++) 
 
             for ( j = n/4; j < 3 * n/4; j++) 
 
                 arr[i][j] = (n*n + 1) - arr[i][j]; 
 
         
 
         System.out.println("The Magic Square for "+n+":"); 
 
         System.out.println("Sum of each row or column "+n*(n*n+1)/2+":"); 
 
         // Printing the magic-square 
 
         for (i = 0; i < n; i++) 
 
         { 
 
             for ( j = 0; j < n; j++) 
 
                 System.out.print(arr[i][j]+" "); 
 
             System.out.println(); 
 
         } 
 
     }
 
 };
            
            