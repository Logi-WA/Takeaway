package is.vidmot;

import is.vinnsla.Meals;
import is.vinnsla.Menu;
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

public class MenuView extends ListView<Meals> {

    /**
     * Hleður menu-view.fxml og setur rót og controller þess.
     * Setur inn gögn og sækir veitingar.
     */
    public MenuView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Menu menu = new Menu();
        menu.setData();
        setItems(menu.getMeals());
    }
}
