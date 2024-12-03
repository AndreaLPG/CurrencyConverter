package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        QueryCurrency consultation = new QueryCurrency();

        int option = 0;
        Double value;

        System.out.println("*****************************************");
        System.out.println("Welcome to the Exchange:");
        String menu = """
                1.Dollar => Argentine currency
                2.Argentine currency => Dollar
                3.Dollar => Brazilian real
                4.Brazilian real => Dollar
                5.Dollar => Bolivian currency
                6.Bolivian currency => Dollar
                7.Dollar => Chilean currency
                8.Chilean currency => Dollar
                9.Dollar => Colombian currency
                10.Colombian currency => Dollar
                11.Out""";


        while (option != 11) {
            System.out.println("\n");
            System.out.println(menu);
            System.out.println("\nChoise a option. ");
            option = read.nextInt();


            String base_code = null;
            String target_code = null;


            switch (option) {
                case 1:
                    base_code = "USD";
                    target_code = "ARS";
                    System.out.println("How much do you want to convert from Dollar to Argentine currency");
                    break;
                case 2:
                    base_code = "ARS";
                    target_code = "USD";
                    System.out.println("How much do you want to convert from Argentine currency to Dollar");
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    System.out.println("How much do you want to convert from Dollar to Brazilian currency");
                    break;
                case 4:
                    base_code = "BRL";
                    target_code = "USD";
                    System.out.println("How much do you want to convert from Brazilian currency to Dollar  ");
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "BOB";
                    System.out.println("How much do you want to convert from Dollar to Bolivian currency  ");

                    break;
                case 6:
                    base_code = "BOB";
                    target_code = "USD";
                    System.out.println("How much do you want to convert from Bolivian currency to Dollar");
                    break;
                case 7:
                    base_code = "USD";
                    target_code = "CLP";
                    System.out.println("How much do you want to convert from Dollar to Chilean currency");
                    break;
                case 8:
                    base_code = "CLP";
                    target_code = "USD";
                    System.out.println("How much do you want to convert from Dollar to Chilean currency");
                    break;
                case 9:
                    base_code = "USD";
                    target_code = "COP";
                    System.out.println("How much do you want to convert from Dollar to Colombian currency");
                    break;
                case 10:
                    base_code = "COP";
                    target_code = "USD";
                    System.out.println("How much do you want to convert from Colombian currency to Dollar");
                    break;

                case 11:
                    System.out.println("Exit");
                    continue;
                default:
                    System.out.println("Bad option. Try again. \n");
                    continue;

            }


            value = read.nextDouble();

            try {

                double conversionRate = consultation.converter(base_code, target_code);
                System.out.println("Exchange rate: " + base_code + " to " + target_code + " is: " + conversionRate);

                double result = value * conversionRate;
                System.out.println("The value is: " + result +" " + target_code);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Ending.");
            }

        }

      //read.close(); // Cierra el Scanner para liberar recursos

    }
}