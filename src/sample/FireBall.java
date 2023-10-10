package sample;

/**
 * The type Fire ball.
 */
public class FireBall extends Spells{
    /**
     * Instantiates a new Fire ball.
     *
     * @param url the url
     */
    public FireBall(String url) {
        super(0,325,70,url,5.0,Place.AIRandGROUND,Place.AIRandGROUND);
        number=1;
        dur=6;
        dmg=144;
        rng=5;
        if(Controller.player.getXp()>2499)
        {
            hp=127;
            dmg=474;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=151;
            dmg=432;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=166;
            dmg=393;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=182;
            dmg=357;
        }
    }
}
