package is.vidmot;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    PONTUN("pontun-view.fxml"),
    GREIDSLA("greidsla-view.fxml"),
    VIDSKIPTAVINUR("vidskiptavinur-view.fxml"),
    PASSWORD("login-view.fxml"); //Viðbót sem ég bætti við til að setja mann í login-view í stað vidskiptavinur-view.
    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
