package is.vidmot;

import is.vinnsla.Cart;
import is.vinnsla.Meals;
import is.vinnsla.Customer;
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

public class PontunController {
    //Viðmótsbreytur
    public Hyperlink fxHyperText;
    public Label fxWarning;
    @FXML
    private MatsedillView matsedillView;
    @FXML
    private ListView<Meals> karfaListView;
    @FXML
    private Label heildarVerdLabel;

    //Tengsl við vinnslu
    private Cart karfa;
    private Customer vidskiptavinur;


    /**
     * Ef maður ýtir á takkann til að setja ákveðna veitingu í körfu þá er fundið
     * vöruna sem viðskiptavinur vill setja í körfuna og svo bætt henni við í körfuna.
     *
     * @param event - atburðurinn sem viðmótshluturinn fékk
     */
    @FXML
    private void fxSetjaKorfuHandler(ActionEvent event) {
        Meals selectedMeal = matsedillView.getSelectionModel().getSelectedItem();
        karfaListView.setItems(karfa.getKarfa());
        if (selectedMeal != null) {
            karfa.getKarfa().add(selectedMeal);
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
    private void fxTakaKorfuHandler(ActionEvent event) {
        if (karfaListView.getSelectionModel().getSelectedItems() != null)
            karfaListView.getItems().remove(karfaListView.getSelectionModel().getSelectedItem());
    }

    /**
     * Notað til þess að tengja viðskiptavin úr VidskiptavinurDialog hingað
     * og gerir hann nothæfan hér.
     *
     * @param vidskiptavinur - Viðskiptavins-hlutur til að ákvarða viðskiptavin klasans.
     */
    public void setVidskiptavinur(Customer vidskiptavinur) {
        this.vidskiptavinur = vidskiptavinur;
    }

    /**
     * Ef ýtt er á 'Innskráning' takkann er kíkt á hvort það er viðskiptavinur
     * í kerfinu eða ekki. Ef það er enginn fær maður að búa til nýjann
     * viðskiptavin og ef það er viðskiptavinur til staðar í kerfinu kemur
     * gluggi þar sem hægt er að skrifa lykilorð og ekkert meira.
     *
     * @param actionEvent atburðurinn sem viðmótshluturinn fekk.
     */
    public void fxInnskr(ActionEvent actionEvent) {
        if (vidskiptavinur == null) {
            ViewSwitcher.switchTo(View.VIDSKIPTAVINUR);
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
        karfa = new Cart();
        karfa.getHeildarVerd().addListener((observable, oldValue, newValue) -> {
            heildarVerdLabel.textProperty().bind(karfa.heildarVerdProperty().asString().concat("kr."));
        });
        karfaListView.setItems(karfa.getVeitingar());
    }

    /**
     * Ef ýtt er á 'Greiða' takkann, þá er kíkt hvort viðskiptavinur
     * til staðar í kerfinu. Ef enginn er til staðar þá birtist viðvörun
     * sem segir manni að skrá sig inn. Ef það er viðskiptavinur til staðar
     * þá fær maður að halda áfram í greiðslusenu.
     *
     * @param actionEvent - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxGreidslaHandler(ActionEvent actionEvent) {
        if (vidskiptavinur == null) {
            fxWarning.setOpacity(1.0);
        } else {
            ViewSwitcher.switchTo(View.GREIDSLA);
        }
    }

    /**
     * Aðferð til að sækja körfu.
     *
     * @return - Skilar körfuhlutinum karfa.
     */
    public Cart getKarfa() {
        return karfa;
    }

    /**
     * Aðferð til að sækja viðskiptavin.
     *
     * @return - Skilar viðskiptavins-hlutinum viðskiptavinur
     */
    public Customer getVidskiptavinur() {
        return vidskiptavinur;
    }
}
