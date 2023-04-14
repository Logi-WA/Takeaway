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

    /**
     * Hér að neðan er tilraun að DialogPane.
     */
/*
public class CustomerDialog extends Dialog<Customer> {

 */

    /* Virkar fyrir utan takka
    @FXML
    public Button fxCancel;
    @FXML
    public Button fxAfram;
    public TextField fxNafn;
    public TextField fxhFang;

    public CustomerDialog(Customer customer) {
        setTitle("Log In");
        setResizable(false);
        setHeaderText("Log In");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-view.fxml"));
            loader.setController(this);
            DialogPane dialogPane = loader.load();
            setDialogPane(dialogPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

        fxNafn = (TextField) getDialogPane().lookup("#fxName");
        fxhFang = (TextField) getDialogPane().lookup("#fxAddress");
        fxAfram = (Button) getDialogPane().lookupButton(ButtonType.OK);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(fxNafn, 0, 0);
        grid.add(fxhFang, 0, 1);

        getDialogPane().setContent(grid);

        setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                return new Customer(fxNafn.getText(), fxhFang.getText());
            }
            return null;
        });

        fxAfram.disableProperty().bind(Bindings.createBooleanBinding(
                () -> fxNafn.getText().trim().isEmpty() || fxhFang.getText().trim().isEmpty(),
                fxNafn.textProperty(),
                fxhFang.textProperty()
        ));

    }

    @FXML
    public void initialize() {
        fxAfram.setOnAction(actionEvent -> {
            setResultConverter(buttonType -> {
                if (buttonType == ButtonType.OK) {
                    String nafn = fxNafn.getText();
                    String heimilisfang = fxhFang.getText();
                    Customer customer = new Customer(nafn, heimilisfang);
                    return customer;
                }
                return null;
            });
            close();
        });
        fxCancel.setOnAction(actionEvent -> {
            setResult(null);
            close();
        });
    }

     */
}
