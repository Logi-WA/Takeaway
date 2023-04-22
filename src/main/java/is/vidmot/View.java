package is.vidmot;

public enum View {
    ORDER("order-view.fxml"),
    PAYMENT("payment-view.fxml"),
    CUSTOMER("customer-view.fxml"),
    PASSWORD("login-view.fxml");
    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
