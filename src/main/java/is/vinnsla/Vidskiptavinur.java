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

public class Vidskiptavinur {
    //tilviksbreytur
    private StringProperty nafn;// = new SimpleStringProperty();
    private StringProperty hFang;// = new SimpleStringProperty();

    /**
     * Smiður til að skilgreina nýjan viðskiptavin.
     * Tekur ákvarðaða nafn og heimilisfang viðskiptavins
     * og lætur breyturnar verða að breytum klasans.
     *
     * @param nafn  - Nafn viðskiptavins, sláð inn í vidskiptavinur-view.fxml
     * @param hFang - Heimilisfang viðskiptavins, sláð inn í vidskiptavinur-view.fxml
     */
    public Vidskiptavinur(String nafn, String hFang) {
        this.nafn = new SimpleStringProperty(nafn);
        this.hFang = new SimpleStringProperty(hFang);
    }

    /**
     * Aðferð til að sækja viðskiptavin með strengjasniði.
     *
     * @return - Skilar hlutnum Viðskiptavin sem hefur nafn
     * og heimilisfang með kommu á milli þeirra.
     */
    public String toString() {
        return "Vidskiptavinur{" +
                "nafn=" + nafn +
                ", hFang=" + hFang +
                '}';
    }

    /**
     * Aðferð til að sækja heimilisfang viðskiptavins.
     *
     * @return - Skilar heimilisfangi, ákvarðað í vidskiptavinur-view.fxml
     */
    public String gethFang() {
        return hFang.get();
    }

    /**
     * Aðferð til að sækja nafn viðskiptavins.
     *
     * @return Skilar nafni viðskiptavins, ákvarðað í vidskiptavinur-view.fxml
     */
    public String getNafn() {
        return nafn.get();
    }

    /**
     * Aðferð til að sækja nafns-eiginleika viðskiptavins.
     *
     * @return - Skilar StringProperty-inu nafn.
     */
    public StringProperty nafnProperty() {
        return nafn;
    }
}
