package is.vidmot;

import is.vinnsla.Cart;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Controller fyrir greidsla-view.fxml. Getur séð afhendingartíma,
 *  staðinn sem á að afhenda til, heildarverð. Takkar til að staðfesta og
 *  hætta við.
 *
 *****************************************************************************/

public class GreidslaController {
    //Viðmótsbreytur
    @FXML
    public Label fxVerd;
    @FXML
    public Label fxTimi;
    public Label fxAddress;
    public Button fxConfirm;

    public GreidslaController() {
    }

    /**
     * Frumstillir.
     * Sækir gögn um hversu margar veitingar eru í körfu, sækir heildarverð körfu,
     * og sækir afhendingastað og sýnir það allt. Gerir grunn-afhendingartímann 7
     * mínútur og fyrir hverja vöru í körfuna bætast við 2-5 mínútur.
     */
    public void initialize() {
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN); //Sækir PontunController og gerir klasann nothæfann.
        Cart karfa = pontunController.getKarfa(); //Sækir körfu
        fxVerd.textProperty().bind(new SimpleStringProperty("Til greiðslu: ").concat(karfa.getHeildarVerd().asString()).concat("kr.")); //Bindir heildarverð við viðmótshlut
        int fjoldi = karfa.getKarfa().size(), afhendingartimi = 7, count = 0; //breytur fyrir afhendingartíma.
        while (count <= fjoldi) { //while-loopa sem bætir við 2-5 mínutum fyrir hvern hlut sem er í körfu.
            int i = (int) (Math.random() * 6);
            if (i < 6 && i > 1) {
                afhendingartimi += i;
                count++;
                System.out.println(fjoldi);
            }
        }
        fxTimi.textProperty().bind(new SimpleStringProperty("Afhendingartími: ~").concat(Integer.toString(afhendingartimi).concat("m")));
        fxAddress.textProperty().bind(new SimpleStringProperty("Til: ").concat(pontunController.getVidskiptavinur().gethFang()));

    }

    /**
     * Þegar ýtt er á staðfesta hættir maður að sjá hann og maður sér texta
     * sem var fyrir aftan takkann sem segir 'Takk Fyrir'!
     *
     * @param actionEvent - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxStadfestaHandler(ActionEvent actionEvent) {
        ((PontunController) (ViewSwitcher.lookup(View.PONTUN))).getKarfa().getVeitingar().removeAll();
        fxConfirm.setOpacity(0.0);

    }

    /**
     * Þegar ýtt er á takkann fer maður aftur í pontun-view.fxml
     *
     * @param actionEvent - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxCancel(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.PONTUN);
    }
}
