// Rayhan Ali Darmawan - 2301891683


import java.util.Scanner;



public class shopexercise

{

    public static void main(String[] arg)

    {   

        

        String productName[] = {"Processor", "RAM" , "Power Supply","Graphic Card","SSD"};

        int productPrice[] = {2560000,1250000,870000,3850000,1050000};

        int totalPrice;

        int selectProduct;

        int selectAmount;

        int inputMoney;



        

        System.out.println("Computer Shop");

        System.out.println("===========================");

        

        for(int i = 0; i < productName.length;i++)

        {

            System.out.print((i+1) + ". " + productName[i] + " - " + "Rp." + productPrice[i] + "\n");

        }

        System.out.println("===========================");

        

        

        Scanner sc = new Scanner(System.in);

        

        

        System.out.println("Choose Product: ");

        selectProduct = sc.nextInt();

    

        if(selectProduct <= productName.length & selectProduct > 0)

        {

            System.out.println("Selected Product : " + productName[selectProduct-1]);

            System.out.println("===========================");



            // Choosing Amount

            System.out.println("Input Quantity [1-20]: ");

            selectAmount = sc.nextInt();

            if(selectAmount<= 20 & selectAmount > 0)

            {

                System.out.println("===========================");



                

                totalPrice = selectAmount * productPrice[selectProduct-1];

                System.out.println("Total Price : Rp." + totalPrice);

                System.out.println("Input money [bigger or equals to price]: ");

                inputMoney = sc.nextInt();



            

                if(inputMoney == totalPrice)

                {

                    System.out.println("You pay with the exact amount of money!");

                }

                

                else if(inputMoney > totalPrice)

                {

                    System.out.println("You get Rp." + (inputMoney-totalPrice) + " for the change");

                }



                else

                {

                    System.out.println("You don't have enough money!");

                }

            }



            else

            {

                System.out.println("Invalid Quantity!");

                System.exit(0);

            }

        }



        else

        {

            System.out.println("Invalid Product!");

            System.exit(0);

        }



        sc.close();

    }



    



}