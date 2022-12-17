package co.com.example;

import java.util.Scanner;

public class MagicMops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to magic mops\n");

        System.out.println("Please enter the document number:");
        String documentNumber = scanner.nextLine();

        System.out.println("Enter the price of the cotton mops per dozen:");
        double cottonPriceM = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the price of sponge mops per dozen:");
        double spongePriceM = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the price of the microfiber mops per dozen:");
        double microfiberPriceM = Double.parseDouble(scanner.nextLine());

        int quantityCottonM = 0;
        int quantitySpongeM = 0;
        int quantityMicrofiberM = 0;

        double totalPriceCottonM = 0;
        double totalPriceSpongeM = 0;
        double totalPriceMicrofiberM = 0;

        double DISCOUNT_COTTON_M1 = 10.72;
        double DISCOUNT_COTTON_M2 = 20.25;
        double DISCOUNT_SPONGE_M1 = 15.25;
        double DISCOUNT_SPONGE_M2 = 20.15;
        double DISCOUNT_MICROFIBER_M1 = 20.2;

        double FULL_DISCOUNT1 = 5;
        double FULL_DISCOUNT2 = 7.5;

        System.out.println("\nDozen Mops Price List: \nCotton mop: $" + cottonPriceM + "\nSponge mop: $" + spongePriceM + "\nMicrofiber mop: $" + microfiberPriceM);

        boolean executePurchase = true;

        while (executePurchase) {
            System.out.println("\nPlease enter the number of the type of mop you wish to purchase: \n10 -> Cotton mop \n20 -> Sponge mop \n30 -> Microfiber mop");
            int mopOption = Integer.parseInt(scanner.nextLine());

            switch (mopOption) {
                case 10:
                    System.out.println("Enter the number of dozens of cotton mops you wish to purchase:");
                    quantityCottonM = Integer.parseInt(scanner.nextLine());
                    totalPriceCottonM = cottonPriceM * quantityCottonM;
                    if (quantityCottonM > 18 && quantityCottonM <= 30) {
                        totalPriceCottonM *= 1 - DISCOUNT_COTTON_M1 / 100;
                    } else if (quantityCottonM > 30) {
                        totalPriceCottonM *= 1 - DISCOUNT_COTTON_M2 / 100;
                    }
                    break;
                case 20:
                    System.out.println("Enter the number of dozens of sponge mops you wish to purchase:");
                    quantitySpongeM = Integer.parseInt(scanner.nextLine());
                    totalPriceSpongeM = spongePriceM * quantitySpongeM;
                    if (quantitySpongeM > 14 && quantitySpongeM <= 28) {
                        totalPriceSpongeM *= 1 - DISCOUNT_SPONGE_M1 / 100;
                    } else if (quantitySpongeM > 28) {
                        totalPriceSpongeM *= 1 - DISCOUNT_SPONGE_M2 / 100;
                    }
                    break;
                case 30:
                    System.out.println("Enter the number of dozens of microfiber mops you wish to purchase:");
                    quantityMicrofiberM = Integer.parseInt(scanner.nextLine());
                    totalPriceMicrofiberM = microfiberPriceM * quantityMicrofiberM;
                    if (quantityMicrofiberM > 12) {
                        totalPriceMicrofiberM *= 1 - DISCOUNT_MICROFIBER_M1 / 100;
                    }
                    break;
                default:
                    System.out.println("Invalid option");
            }

            System.out.println("Do you want to continue shopping?? (s/n)");
            char makePurchase = scanner.nextLine().toLowerCase().charAt(0);
            switch (makePurchase) {
                case 's':
                    executePurchase = true;
                    break;
                case 'n':
                    executePurchase = false;
                    int fullQuantityDozen = quantityCottonM + quantitySpongeM + quantityMicrofiberM;
                    int totalQuantityUnit = fullQuantityDozen * 12;
                    double totalPrice = totalPriceCottonM + totalPriceSpongeM + totalPriceMicrofiberM;

                    if (fullQuantityDozen >= 18 && fullQuantityDozen <= 24){
                        totalPrice *= 1 - FULL_DISCOUNT1 / 100;
                    } else if (fullQuantityDozen > 24) {
                        totalPrice *= 1 - FULL_DISCOUNT2 / 100;
                    }

                    System.out.println("*****************INVOICE***************** \nUser: " + documentNumber + "\nTotal amount in dozens: " + fullQuantityDozen + "\nTotal quantity in units: " + totalQuantityUnit + "\nFull price to pay: $" + totalPrice);
                    if (fullQuantityDozen >= 18 && fullQuantityDozen <= 24){
                        System.out.println("You got an extra discount from " + FULL_DISCOUNT1 + "%");
                    } else if (fullQuantityDozen > 24) {
                        System.out.println("You got an extra discount from " + FULL_DISCOUNT2 + "%");
                    }

                    System.out.println("\n************INVOICE DETAILS************* \nCotton mops \nQuantity: " + quantityCottonM + "\nPrice: $" + totalPriceCottonM);
                    if (quantityCottonM > 18 && quantityCottonM <= 30) {
                        System.out.println("You got a discount from " + DISCOUNT_COTTON_M1 + "%");
                    } else if (quantityCottonM > 30) {
                        System.out.println("You got a discount from " + DISCOUNT_COTTON_M2 + "%");
                    }

                    System.out.println("----------------------------------------- \nSponge mops \nQuantity: " + quantitySpongeM + "\nPrice: $" + totalPriceSpongeM);
                    if (quantitySpongeM > 14 && quantitySpongeM <= 28) {
                        System.out.println("You got a discount from " + DISCOUNT_SPONGE_M1 + "%");
                    } else if (quantitySpongeM > 28) {
                        System.out.println("You got a discount from " + DISCOUNT_SPONGE_M2 + "%");
                    }

                    System.out.println("----------------------------------------- \nMicrofiber mops \nQuantity: " + quantityMicrofiberM + "\nPrice: $" + totalPriceMicrofiberM);
                    if (quantityMicrofiberM > 12){
                        System.out.println("You got a discount from " + DISCOUNT_MICROFIBER_M1 + "%");
                        break;
                    }
                default:
                    System.out.println("Invalid option");
            }
        }
        System.out.println("\nWe wish you a happy day!");
    }
}
