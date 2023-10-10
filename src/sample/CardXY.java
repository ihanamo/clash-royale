package sample;

/**
 * The type Card xy.
 */
public class CardXY {
    /**
     * The Card.
     */
    Cards card;
    /**
     * The X.
     */
    double x, /**
     * The Y.
     */
    y;
    /**
     * The U pic.
     */
    String uPic, /**
     * The D pic.
     */
    dPic, /**
     * The Hit pic.
     */
    hitPic;

    /**
     * Instantiates a new Card xy.
     *
     * @param card   the card
     * @param uPic   the u pic
     * @param dPic   the d pic
     * @param hitPic the hit pic
     * @param x      the x
     * @param y      the y
     */
    public CardXY(Cards card,String uPic,String dPic,String hitPic, double x, double y) {
        this.card = card;
        this.x = x;
        this.y = y;
        this.dPic=dPic;
        this.uPic=uPic;
        this.hitPic=hitPic;
    }
}
