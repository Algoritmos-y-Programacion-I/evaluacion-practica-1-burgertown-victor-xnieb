package ui;

import java.util.Scanner;

public class BurgerTown {

    public static Scanner in;
    public static double[] prices;
    public static int[] units;

    public static void main(String[] args) {

        initializeGlobals();
        menu();
    }

    /**
    * Description: This method is in charge of starting the global variables.
    *pre: The Scanner reader must be declared
    *pos: The Scanner reader is initialized
    */
    public static void initializeGlobals() {

        in = new Scanner(System.in);

    }

    /**
    * Description: This method is in charge of displaying the menu to the user and showing the result messages for each functionality.
    * pre: The Scanner reader must be initialized.
    * pre: The price array must be initialized.
    */
    public static void menu() {

        System.out.println("Welcome to BurgerTown!");

        setQuantitySold();

        boolean exit = false;
        
        do {

            System.out.println("\nMain Menu");
            System.out.println("1. Request prices ($) and quantities of each dish sold during the day.");
            System.out.println("2. Calculate the total amount of plates sold in the day.");
            System.out.println("3. Calculate the average price of the dishes sold during the day.");
            System.out.println("4. Calculate total sales (money collected) during the day");
            System.out.println("5. Consult the number of plates that have exceeded a minimum sales limit during the day.");
            System.out.println("6. exit");
            System.out.println("\nType the option to execute");
            int opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    requestData();
                    break;
                case 2:
                    System.out.println("\nThe total amount of plates sold on the day was: "+calculateTotalDishesSold());
                    break;
                case 3:
                    System.out.println("\nThe average price of the dishes sold during the day was: "+calculateAveragePrice());
                    break;
                case 4:
                    System.out.println("\nTotal sales (money raised) during the day were: "+calculateTotalSales());
                    break;
                case 5:
                    System.out.println("\nEnter the minimum sales limit to analyze");
                    double limit = in.nextDouble();
                    System.out.println("\nOf the "+precios.length+" references sold during the day, "+checkDishesAboutLimit(limit)+" exceeded the minimum sales limit of "+limit);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    exit = true;
                    in.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de platos diferentes 
     * vendidos en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void setQuantitySold() {

        System.out.println("\nDigite el numero de platos diferentes vendidos en el dia ");
        int platos = in.nextInt();

        prices = new double[platos];
        units = new int[platos];

    }

    /**
     * This method requests the price and quantities sold for each product.
     */
    public static void requestData(){
        int a=0;
        int i = 0;
        while (i<prices.length){
            System.out.println("Ingrese el precio del producto "+ (a+1)  );  
            double productPrice= in.nextDouble();
            prices[i]=productPrice;

            System.out.println("Ingrese la cantidad total vendida de este producto");
            int numSold= in.nextInt();
            units[i]=numSold;

            i++;
            a++;
        }
        
     
    }

    public static int calculateTotalDishesSold(){
        int i=0;
        int totalPlatesSold=0;

        while(i<units.length){

            totalPlatesSold = totalPlatesSold + units[i];
            i++;
        }
        return totalPlatesSold;

    }

    public static double calculateAveragePrice(){

        int i=0;
        double sumPrices=0;
        int platos=3;    

        while(i<prices.length){
            sumPrices+=prices[i];
            i++;
        }

        double average= sumPrices/prices.length;

        return average;

    }
    /**
     * Method for calculating total sales
     * @return double totalSold, total sales
     */
    public static double calculateTotalSales(){

        double totalSold = 0;
        for (int i=0;i<prices.length;i++){

            totalSold=totalSold+(prices[i]*units[i]);

        }

        return totalSold;

    }

    /**
     * Method to verify the plates that exceeded a sales limit.
     * @param double limit, minimum amount
     */
    public static int checkDishesAboutLimit(double limit){
        double salesProduct=0;
        int numPlatesReachedLim=0;
        for (int i=0;i<precios.length;i++){

            salesProduct=prices[i]*units[i];

            if (salesProduct>=limit){
                numPlatesReachedLim++;

            }

        }



        return numPlatesReachedLim;

    }

}