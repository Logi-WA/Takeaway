package is.vidmot;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    ORDER("order-view.fxml"),
    PAYMENT("payment-view.fxml"),
    CUSTOMER("customer-view.fxml"),
    PASSWORD("login-view.fxml"); //Viðbót sem ég bætti við til að setja mann í login-view í stað vidskiptavinur-view.
    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
