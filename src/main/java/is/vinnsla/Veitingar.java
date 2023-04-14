package is.vinnsla;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Vinnsluklasi sem hefur aðgerðir sem gerir
 *  manni kleift að skilgreina nýja veitingu á einfaldan
 *  hátt. Aðferðir til að sækja verð veitingar og aðferð
 *  til að sækja veitingu með verði sem streng.
 *
 *****************************************************************************/

public class Veitingar {
    //tilviksbreytur
    private String veiting;
    private int verd;

    /**
     * Aðferð til að skilgreina nýja veitingu. Tekur inn
     * heiti veitingar og verð þess og setur breyturnar
     * sem virku breytur klasans. Það þarf að bæta veitingu
     * við á listann með setGogn() í Matsedill áður en maður
     * ætlar að gera nýja veitingu
     *
     * @param veiting - Strengur sem á að vera heiti veitingar.
     * @param verd    - Heiltala sem á að vera verð veitingar.
     */
    public Veitingar(String veiting, int verd) {
        this.veiting = veiting;
        this.verd = verd;
    }

    /**
     * Aðferð til að sækja verð veitingu og
     * skilar verði vetingarinnar.
     */
    public int getVerd() {
        return verd;
    }

    /**
     * Aðferð til að færa veitingarhlut í strengjasnið
     *
     * @return - Skilar streng með sniði sem gerir
     * streng sem er veiting og heiltölu sem er verð
     * veitingar. Skilar þeim sem streng með bannstriki
     * á milli þeirra.
     */
    public String toString() {
        return String.format("%s - %dkr. ", veiting, verd);
    }
}
