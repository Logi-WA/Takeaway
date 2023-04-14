package is.vidmot;

import is.vinnsla.Matsedill;
import is.vinnsla.Veitingar;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Endurnýtanlegur klasi fyrir matseðilshluta pöntunarsenunnar.
 *
 *
 *****************************************************************************/

public class MatsedillView extends ListView<Veitingar> {

    /**
     * Hleður matsedill-view.fxml og setur rót og controller þess.
     * Setur inn gögn og sækir veitingar.
     */
    public MatsedillView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matsedill matsedill = new Matsedill();
        matsedill.setGogn();
        setItems(matsedill.getVeitingar());
    }
}
