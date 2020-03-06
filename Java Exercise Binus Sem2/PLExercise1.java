//Rayhan Ali Darmawan - 2301891683

//Exercise 1



import java.util.Arrays;





public class PLExercise1

{

    public static void main(String[] args)

    {

        // For lowercase to uppercase

        int mask = '\u00DF';

        int char1 = 'e';

        int uc = char1 & mask;

        System.out.printf("%c",char1);

        System.out.println();

        System.out.printf("%c",uc);



        System.out.println("\n");



        // For uppercase to lowercase

        int mask2 = '\u0020';

        int char2 = 'B';

        int uc2 = char2 | mask2;

        System.out.printf("%c",char2);

        System.out.println();

        System.out.printf("%c",uc2);



        System.out.println("\n");

        

        // Ascii to digit

        int mask3 = '\u0030';

        int char3 = '4';

        int uc3 = char3 | mask3;

        System.out.printf("%d \n",uc3);



        //Digit to Ascii

        int mask4 = '\u00CF';

        int char4 = '5';

        int uc4 = char4 & mask4;

        System.out.printf("%d \n",uc4);



        //reversing contents of input array



        int x[] = {1,2,3,4,5};



        int y[] = new int[x.length];



        for (int i = 0;i < x.length; i++)

        {

            y[i] = x[x.length-1-i];

        }



        System.out.print(Arrays.toString(y));



        

    







    }

}