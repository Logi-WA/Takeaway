package is.vidmot;

import is.vinnsla.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *     ATH! ÉG NÁÐI EKKI AÐ GERA DIALOG EINS OG VAR BEÐIÐ UM EN KÓÐINN SEM ÉG HAFÐI
 *     ÞAR TIL AÐ ÉG GAFST UPP ER Í BLÁU NEÐST Í ÞESSUM KLASA. ÉG GAT EKKI ÝTT Á
 *     TAKKANA Í DIALOGINUM OG FANN EKKI LEIÐ TIL AÐ LAGFÆRA OG HALDA ÁFRAM.
 *     Þar af leiðandi ákvað ég að gera CustomerDialog og það sem tengist
 *     viðskiptavin í kerfinu án þess að nota dialog.
 *
 *  Lýsing  : Stýring fyrir senu til þess að skrá sig sem viðskiptavin
 *
 *****************************************************************************/

public class ClientDialog {
    //Viðmótsbreytur
    @FXML
    public TextField fxName;
    @FXML
    public TextField fxAddress;
    @FXML
    public Button fxOk;
    @FXML
    public Button fxCancel;
    //Tengsl við vinnslu
    private Customer customer;

    /**
     * Þegar ýtt er á takkann til að halda áfram þá er tekið nafn
     * og heimilisfang sem voru slegin inn í text-field og skilgreint
     * nýjan viðskiptavin. Svo er tengt viðskiptavininn við
     * OrderController, breytt svo texta Hyperlinks-ins sem notaður
     * er til þess að skrá sig inn, ef það kom viðvörun um að skrá
     * sig inn hverfur hún og svo er skipt aftur í pontun-view.
     */
    @FXML
    private void fxOk() {
        String name = fxName.getText();
        String address = fxAddress.getText();
        Customer customer = new Customer(name, address);
        OrderController orderController = (OrderController) ViewSwitcher.controllers.get(View.ORDER);
        orderController.setCustomer(customer);
        orderController.fxHyperText.setText("Welcome " + customer.getName());
        orderController.fxWarning.setOpacity(0.0);
        ViewSwitcher.switchTo(View.ORDER);
    }

    /**
     * Ef ýtt er á takkann til að hætta við fer maður
     * aftur í pontun-view.
     */
    @FXML
    private void fxCancel() {
        ViewSwitcher.switchTo(View.ORDER);
    }


}
