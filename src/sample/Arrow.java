package sample;

/**
 * The type Arrow.
 */
public class Arrow extends Cards{
    /**
     * Instantiates a new Arrow.
     *
     * @param url the url
     */
    public Arrow(String url) {
        super(0,150,56,url,5.0,Place.AIRandGROUND,Place.AIRandGROUND);
        if(Controller.player.getXp()>2499)
        {
            hp=127;
            dmg=210;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=151;
            dmg=189;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=166;
            dmg=174;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=182;
            dmg=156;
        }
    }
}
