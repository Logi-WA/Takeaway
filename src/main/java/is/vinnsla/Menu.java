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

public class Menu {
    protected ObservableList<Meals> meals = FXCollections.observableArrayList();

    /**
     * Aðferð sem gerir manni kleift að búa til nýjar
     * veitingar og bæta þeim við á matseðil með því
     * að búa til nýjan 'Veitingar' hlut sem hægt er
     * að bæta svo á ObservableList listann að nafni
     * veitingar.
     */
    public void setGogn() {
        Meals margherita = new Meals("Margherita pizza, 16'", 1690);
        meals.add(margherita);
        Meals hawaiian = new Meals("Hawaiian pizza, 16'", 1890);
        meals.add(hawaiian);
        Meals cheeseburger = new Meals("Cheeseburger, 150gr", 990);
        meals.add(cheeseburger);
        Meals bulluBurger = new Meals("Búlluborgari, 200gr", 1290);
        meals.add(bulluBurger);
        Meals smallFries = new Meals("Litlar franskar, 300gr", 560);
        meals.add(smallFries);
        Meals largeFries = new Meals("Stórar franskar, 600gr", 990);
        meals.add(largeFries);
        Meals coke = new Meals("Coca-Cola, 330ml", 290);
        meals.add(coke);
        Meals pax = new Meals("Pepsi Max, 500ml", 390);
        meals.add(pax);
        Meals teilari = new Meals("Kokteilsósa, 200ml", 290);
        meals.add(teilari);

    }

    /**
     * Aðferð til að sækja veitingarnar á matseðli.
     *
     * @return - skilar lista af veitingum
     */
    public ObservableList<Meals> getMeals() {
        return meals;
    }
}
