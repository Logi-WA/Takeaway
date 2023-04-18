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

public class PaymentController {
    //Viðmótsbreytur
    @FXML
    public Label fxPrice;
    @FXML
    public Label fxTime;
    public Label fxAddress;
    public Button fxConfirm;

    public PaymentController() {
    }

    /**
     * Frumstillir.
     * Sækir gögn um hversu margar veitingar eru í körfu, sækir heildarverð körfu,
     * og sækir afhendingastað og sýnir það allt. Gerir grunn-afhendingartímann 7
     * mínútur og fyrir hverja vöru í körfuna bætast við 2-5 mínútur.
     */
    public void initialize() {
        OrderController orderController = (OrderController) ViewSwitcher.lookup(View.ORDER); //Sækir OrderController og gerir klasann nothæfann.
        Cart cart = orderController.getCart(); //Sækir körfu
        fxPrice.textProperty().bind(new SimpleStringProperty("Price: ").concat(cart.getTotalPrice().asString()).concat("kr.")); //Bindir heildarverð við viðmótshlut
        int amount = cart.getCart().size(), deliverytime = 7, count = 0; //breytur fyrir afhendingartíma.
        while (count <= amount) { //while-loopa sem bætir við 2-5 mínutum fyrir hvern hlut sem er í körfu.
            int i = (int) (Math.random() * 6);
            if (i < 6 && i > 1) {
                deliverytime += i;
                count++;
                System.out.println(amount);
            }
        }
        fxTime.textProperty().bind(new SimpleStringProperty("Delivery time: ~").concat(Integer.toString(deliverytime).concat("m")));
        fxAddress.textProperty().bind(new SimpleStringProperty("To: ").concat(orderController.getCustomer().getAddress()));

    }

    /**
     * Þegar ýtt er á staðfesta hættir maður að sjá hann og maður sér texta
     * sem var fyrir aftan takkann sem segir 'Takk Fyrir'!
     *
     * @param actionEvent - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxConfirmHandler(ActionEvent actionEvent) {
        ((OrderController) (ViewSwitcher.lookup(View.ORDER))).getCart().getMeals().removeAll();
        fxConfirm.setOpacity(0.0);

    }

    /**
     * Þegar ýtt er á takkann fer maður aftur í order-view.fxml
     *
     * @param actionEvent - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxCancel(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.ORDER);
    }
}
