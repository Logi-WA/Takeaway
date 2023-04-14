package is.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Vinnsluklasi sem hefur körfu sem er listi af veitingum.
 *  Hefur aðferðir til að uppfæra heildarverð.
 *
 *
 *****************************************************************************/

public class Karfa extends Matsedill {
    private ObservableList<Veitingar> karfa = FXCollections.observableArrayList();
    private final IntegerProperty heildarVerd = new SimpleIntegerProperty(0);

    /**
     * Skilar heiltölueiginleika sem heildarverð
     *
     * @return - Skilar heildarverði
     */
    public IntegerProperty heildarVerdProperty() {
        return heildarVerd;
    }

    /**
     * Smiður til að gera körfu. Hlustar á hvort vöru var bætt
     * við og kallar á uppdfærslu heildarverðs körfu.
     */
    public Karfa() {
        karfa.addListener((ListChangeListener<Veitingar>) c -> {
            while (c.next()) {
                if (c.wasAdded() || c.wasRemoved()) {
                    updateHeildarVerd();
                }
            }
        });
    }

    /**
     * Aðferð til að reikna heildarverð körfu. Leggur
     * saman verð allra veitinga í körfu.
     */
    private void updateHeildarVerd() {
        int total = 0;
        for (Veitingar v : karfa) {
            total += v.getVerd();
        }
        heildarVerd.set(total);
    }

    /**
     * Aðferð til að ná í körfuna. Skilar körfunni
     * sem er ObservableList.
     *
     * @return - Skilar körfulistanum.
     */
    public ObservableList<Veitingar> getKarfa() {
        return karfa;
    }

    /**
     * Aðferð til að ná í heildarverð körfunnar.
     * Skilar heildarverðseiginleikanum.
     *
     * @return - Skilar heildarverði.
     */
    public IntegerProperty getHeildarVerd() {
        return heildarVerd;
    }
}
