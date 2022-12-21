package co.com.example;

public class MagicMops {
    public void start() {
        Misc.showMessage("Welcome to magic mops");

        String documentNumber = Misc.getString("Please enter the document number:");

        Float cottonPriceM = Misc.getFloat("Enter the price of the cotton mops per dozen:");
        Float spongePriceM = Misc.getFloat("Enter the price of sponge mops per dozen:");
        Float microfiberPriceM = Misc.getFloat("Enter the price of the microfiber mops per dozen:");

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

        Misc.showMessage("Dozen Mops Price List: \nCotton mop: $" + cottonPriceM + "\nSponge mop: $" + spongePriceM + "\nMicrofiber mop: $" + microfiberPriceM);

        boolean executePurchase = true;

        while (executePurchase) {
            Integer mopOption = Misc.getInteger("Please enter the number of the type of mop you wish to purchase: \n10 -> Cotton mop \n20 -> Sponge mop \n30 -> Microfiber mop");

            switch (mopOption) {
                case 10:
                    quantityCottonM = Misc.getInteger("Enter the number of dozens of cotton mops you wish to purchase:");
                    totalPriceCottonM = cottonPriceM * quantityCottonM;
                    if (quantityCottonM > 18 && quantityCottonM <= 30) {
                        totalPriceCottonM *= 1 - DISCOUNT_COTTON_M1 / 100;
                    } else if (quantityCottonM > 30) {
                        totalPriceCottonM *= 1 - DISCOUNT_COTTON_M2 / 100;
                    }
                    break;
                case 20:
                    quantitySpongeM = Misc.getInteger("Enter the number of dozens of sponge mops you wish to purchase:");
                    totalPriceSpongeM = spongePriceM * quantitySpongeM;
                    if (quantitySpongeM > 14 && quantitySpongeM <= 28) {
                        totalPriceSpongeM *= 1 - DISCOUNT_SPONGE_M1 / 100;
                    } else if (quantitySpongeM > 28) {
                        totalPriceSpongeM *= 1 - DISCOUNT_SPONGE_M2 / 100;
                    }
                    break;
                case 30:
                    quantityMicrofiberM = Misc.getInteger("Enter the number of dozens of microfiber mops you wish to purchase:");
                    totalPriceMicrofiberM = microfiberPriceM * quantityMicrofiberM;
                    if (quantityMicrofiberM > 12) {
                        totalPriceMicrofiberM *= 1 - DISCOUNT_MICROFIBER_M1 / 100;
                    }
                    break;
                default:
                    Misc.showMessage("Invalid option");
            }

            Character makePurchase = Misc.getString("Do you want to continue shopping? (s/n)").toLowerCase().charAt(0);
            switch (makePurchase) {
                case 's':
                    executePurchase = true;
                    break;
                case 'n':
                    executePurchase = false;
                    int fullQuantityDozen = quantityCottonM + quantitySpongeM + quantityMicrofiberM;
                    int totalQuantityUnit = fullQuantityDozen * 12;
                    double totalPrice = totalPriceCottonM + totalPriceSpongeM + totalPriceMicrofiberM;

                    if (fullQuantityDozen >= 18 && fullQuantityDozen <= 24) {
                        totalPrice *= 1 - FULL_DISCOUNT1 / 100;
                    } else if (fullQuantityDozen > 24) {
                        totalPrice *= 1 - FULL_DISCOUNT2 / 100;
                    }

                    Misc.showMessage("*****************INVOICE***************** \nUser: " + documentNumber + "\nTotal amount in dozens: " + fullQuantityDozen + "\nTotal quantity in units: " + totalQuantityUnit + "\nFull price to pay: $" + totalPrice);
                    if (fullQuantityDozen >= 18 && fullQuantityDozen <= 24) {
                        Misc.showMessage("You got an extra discount from " + FULL_DISCOUNT1 + "%");
                    } else if (fullQuantityDozen > 24) {
                        Misc.showMessage("You got an extra discount from " + FULL_DISCOUNT2 + "%");
                    }

                    Misc.showMessage("************INVOICE DETAILS************* \nCotton mops \nQuantity: " + quantityCottonM + "\nPrice: $" + totalPriceCottonM);
                    if (quantityCottonM > 18 && quantityCottonM <= 30) {
                        Misc.showMessage("You got an extra discount from " + FULL_DISCOUNT2 + "%");
                    } else if (quantityCottonM > 30) {
                        Misc.showMessage("You got a discount from " + DISCOUNT_COTTON_M2 + "%");
                    }


                    Misc.showMessage("----------------------------------------- \nSponge mops \nQuantity: " + quantitySpongeM + "\nPrice: $" + totalPriceSpongeM);
                    if (quantitySpongeM > 14 && quantitySpongeM <= 28) {
                        Misc.showMessage("You got a discount from " + DISCOUNT_SPONGE_M1 + "%");
                    } else if (quantitySpongeM > 28) {
                        Misc.showMessage("You got a discount from " + DISCOUNT_SPONGE_M2 + "%");
                    }

                    Misc.showMessage("----------------------------------------- \nMicrofiber mops \nQuantity: " + quantityMicrofiberM + "\nPrice: $" + totalPriceMicrofiberM);
                    if (quantityMicrofiberM > 12) {
                        Misc.showMessage("You got a discount from " + DISCOUNT_MICROFIBER_M1 + "%");
                    }
                    break;
                default:
                    Misc.showMessage("Invalid option");
            }
        }
        Misc.showMessage("\nWe wish you a happy day!");
    }
}