package is.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Vinnsluklasi sem hefur SimpleStringProperties nafn og
 *  heimilisfang. Klasinn er notaður til að skilgreina nýjan
 *  viðskiptavin og geyma hann í kerfinu.
 *
 *
 *****************************************************************************/

public class Customer {
    //tilviksbreytur
    private StringProperty nameProperty;// = new SimpleStringProperty();
    private StringProperty addressProperty;// = new SimpleStringProperty();

    /**
     * Smiður til að skilgreina nýjan viðskiptavin.
     * Tekur ákvarðaða nafn og heimilisfang viðskiptavins
     * og lætur breyturnar verða að breytum klasans.
     *
     * @param nameProperty  - Nafn viðskiptavins, sláð inn í vidskiptavinur-view.fxml
     * @param addressProperty - Heimilisfang viðskiptavins, sláð inn í vidskiptavinur-view.fxml
     */
    public Customer(String nameProperty, String addressProperty) {
        this.nameProperty = new SimpleStringProperty(nameProperty);
        this.addressProperty = new SimpleStringProperty(addressProperty);
    }

    /**
     * Aðferð til að sækja viðskiptavin með strengjasniði.
     *
     * @return - Skilar hlutnum Viðskiptavin sem hefur nafn
     * og heimilisfang með kommu á milli þeirra.
     */
    public String toString() {
        return "Customer{" +
                "Name=" + nameProperty +
                ", Address=" + addressProperty +
                '}';
    }

    /**
     * Aðferð til að sækja heimilisfang viðskiptavins.
     *
     * @return - Skilar heimilisfangi, ákvarðað í vidskiptavinur-view.fxml
     */
    public String getAddress() {
        return addressProperty.get();
    }

    /**
     * Aðferð til að sækja nafn viðskiptavins.
     *
     * @return Skilar nafni viðskiptavins, ákvarðað í vidskiptavinur-view.fxml
     */
    public String getName() {
        return nameProperty.get();
    }

    /**
     * Aðferð til að sækja nafns-eiginleika viðskiptavins.
     *
     * @return - Skilar StringProperty-inu nafn.
     */
    public StringProperty nameProperty() {
        return nameProperty;
    }
}
