package sample;

/**
 * The type Canon.
 */
public class Canon extends Buildings{
    /**
     * Instantiates a new Canon.
     *
     * @param url the url
     */
    public Canon(String url) {
        super(380,60,50,url,1,Place.GROUND,Place.BUILDING);
        hitSpd=0.8;
        rng=10;
        dur=30;
        hp=380;
        dmg=60;
        if(Controller.player.getXp()>2499)
        {
            hp=554;
            dmg=87;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=505;
            dmg=79;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=459;
            dmg=72;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=418;
            dmg=66;
        }
    }
}
