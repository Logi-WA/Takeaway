package is.vidmot;

import is.vinnsla.Cart;
import is.vinnsla.Customer;
import is.vinnsla.Meals;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Stýrir aðalsenu forritsins. Sýnir matseðillinn og veitingar sem
 *  eru í boði á honum. Gerir manni kleift að velja veitingar og bæta þeim við
 *  og taka þær úr körfunni sem hægt er að sjá líka. Hægt að skrá sig inn sem
 *  viðskiptavin í kerfið. Sýnir heildarverð körfunnar og leyfir manni að fara
 *  í greiðsluglugga.
 *
 *
 *****************************************************************************/

public class OrderController {
    //Viðmótsbreytur
    public Hyperlink fxHyperText;
    public Label fxWarning;
    @FXML
    private MenuView menuView;
    @FXML
    private ListView<Meals> cartListView;
    @FXML
    private Label totalPriceLabel;

    //Tengsl við vinnslu
    private Cart cart;
    private Customer customer;


    /**
     * Ef maður ýtir á takkann til að setja ákveðna veitingu í körfu þá er fundið
     * vöruna sem viðskiptavinur vill setja í körfuna og svo bætt henni við í körfuna.
     *
     * @param event - atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    private void fxPutInCartHandler(ActionEvent event) {
        Meals selectedMeal = menuView.getSelectionModel().getSelectedItem();
        cartListView.setItems(cart.getCart());
        if (selectedMeal != null) {
            cart.getCart().add(selectedMeal);
        }
    }

    /**
     * Ef viðskiptavinur ýtir á takkann til þess að taka veitingu úr körfu þá
     * er fundið veitinguna sem valin er í matseðli og tekið síðustu veitingu
     * sem er í körfunni úr körfunni.
     *
     * @param event - atburðurinn sem viðmótshluturinn fékk.
     */
    @FXML
    private void fxRemoveFromCartHandler(ActionEvent event) {
        if (cartListView.getSelectionModel().getSelectedItems() != null)
            cartListView.getItems().remove(cartListView.getSelectionModel().getSelectedItem());
    }

    /**
     * Notað til þess að tengja viðskiptavin úr VidskiptavinurDialog hingað
     * og gerir hann nothæfan hér.
     *
     * @param customer - Viðskiptavins-hlutur til að ákvarða viðskiptavin klasans.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Ef ýtt er á 'Innskráning' takkann er kíkt á hvort það er viðskiptavinur
     * í kerfinu eða ekki. Ef það er enginn fær maður að búa til nýjann
     * viðskiptavin og ef það er viðskiptavinur til staðar í kerfinu kemur
     * gluggi þar sem hægt er að skrifa lykilorð og ekkert meira.
     *
     * @param actionEvent atburðurinn sem viðmótshluturinn fekk.
     */
    public void fxLogIn(ActionEvent actionEvent) {
        if (customer == null) {
            ViewSwitcher.switchTo(View.CUSTOMER);
        } else {
            ViewSwitcher.switchTo(View.PASSWORD);
        }
    }

    /**
     * Býr til körfu, hlustar á hvort veitingu er bætt við í körfuna og
     * uppfærir heildarverð körfunnar. Lætur ListView körfunnar sýna
     * veitingar körfunnar.
     */
    public void initialize() {
        cart = new Cart();
        cart.getTotalPrice().addListener((observable, oldValue, newValue) -> {
            totalPriceLabel.textProperty().bind(cart.totalPriceProperty().asString().concat("kr."));
        });
        cartListView.setItems(cart.getMeals());
    }

    /**
     * Ef ýtt er á 'Greiða' takkann, þá er kíkt hvort viðskiptavinur
     * til staðar í kerfinu. Ef enginn er til staðar þá birtist viðvörun
     * sem segir manni að skrá sig inn. Ef það er viðskiptavinur til staðar
     * þá fær maður að halda áfram í greiðslusenu.
     *
     * @param actionEvent - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxPaymentHandler(ActionEvent actionEvent) {
        if (customer == null) {
            fxWarning.setOpacity(1.0);
        } else {
            ViewSwitcher.switchTo(View.PAYMENT);
        }
    }

    /**
     * Aðferð til að sækja körfu.
     *
     * @return - Skilar körfuhlutinum cart.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Aðferð til að sækja viðskiptavin.
     *
     * @return - Skilar viðskiptavins-hlutinum viðskiptavinur
     */
    public Customer getCustomer() {
        return customer;
    }
}
