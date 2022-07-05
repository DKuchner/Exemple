package utils;

public enum ProductNames {
    SAUCE_LABS_BACKPACK("Sauce Labs Backpack"),
    SAUCE_LABS_BIKE_LIGHT("Sauce Labs Bike Light"),
    SAUCE_LABS_BOLT_T_SHIRT("Sauce Labs Bolt T-Shirt"),
    SAUCE_LABS_FLEECE_JACKET("Sauce Labs Fleece Jacket"),
    SAUCE_LABS_ONESIE("Sauce Labs Onesie"),
    TEST_AllTHETHINGS_T_SHIRT_RED("Test.allTheThings() T-Shirt (Red)");


    private final String product;

    ProductNames(String product) {
        this.product = product;
    }

    public String getProductName() {
        return product;
    }
}
