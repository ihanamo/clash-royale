package sample;

/**
 * The type Queen tower.
 */
public class queenTower extends Cards{
    /**
     * Instantiates a new Queen tower.
     *
     * @param url the url
     */
    public queenTower(String url) {
        super(3000,100,100,url,0.5,Place.AIRandGROUND,Place.BUILDING);
        hp=3000;
    }
}
