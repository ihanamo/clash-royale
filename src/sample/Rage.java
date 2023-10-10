package sample;

/**
 * The type Rage.
 */
public class Rage extends Spells{
    /**
     * Instantiates a new Rage.
     *
     * @param url the url
     */
    public Rage(String url) {
        super(5,5,85,url,0.0,Place.AIRandGROUND,Place.AIRandGROUND);
        number=1;
        dur=6;
        dmg=0;
        rng=10;
    }
}
