package is.vinnsla;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Matseðilsklasinn er vinnsluklasi sem hefur sýnilegan lista
 *  að nafni veitingar. Aðferð til að bæta við veitingum á matseðil og
 *  aðferð til að sækja veitingar.
 *
 *
 *****************************************************************************/

public class Matsedill {
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    /**
     * Aðferð sem gerir manni kleift að búa til nýjar
     * veitingar og bæta þeim við á matseðil með því
     * að búa til nýjan 'Veitingar' hlut sem hægt er
     * að bæta svo á ObservableList listann að nafni
     * veitingar.
     */
    public void setGogn() {
        Veitingar margherita = new Veitingar("Margherita pizza, 16'", 1690);
        veitingar.add(margherita);
        Veitingar hawaiian = new Veitingar("Hawaiian pizza, 16'", 1890);
        veitingar.add(hawaiian);
        Veitingar cheeseburg = new Veitingar("Cheeseburger, 150gr", 990);
        veitingar.add(cheeseburg);
        Veitingar bulluBurger = new Veitingar("Búlluborgari, 200gr", 1290);
        veitingar.add(bulluBurger);
        Veitingar smallFries = new Veitingar("Litlar franskar, 300gr", 560);
        veitingar.add(smallFries);
        Veitingar largeFries = new Veitingar("Stórar franskar, 600gr", 990);
        veitingar.add(largeFries);
        Veitingar coke = new Veitingar("Coca-Cola, 330ml", 290);
        veitingar.add(coke);
        Veitingar pax = new Veitingar("Pepsi Max, 500ml", 390);
        veitingar.add(pax);
        Veitingar teilari = new Veitingar("Kokteilsósa, 200ml", 290);
        veitingar.add(teilari);

    }

    /**
     * Aðferð til að sækja veitingarnar á matseðli.
     *
     * @return - skilar lista af veitingum
     */
    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }
}
