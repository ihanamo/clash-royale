package sample;

/**
 * The type Baby dragon.
 */
public class BabyDragon extends Troops{
    /**
     * Instantiates a new Baby dragon.
     *
     * @param url the url
     */
    public BabyDragon(String url) {
        super(800.0,100.0,100.0,url,1.8,Place.AIRandGROUND,Place.AIRandGROUND);
        number=1;
        hitSpd=1.8;
        hp=800;
        dmg=100;
        rng=100;
        speed=0.5;
        if(Controller.player.getXp()>2499)
        {
            hp=1168;
            dmg=146;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=1064;
            dmg=133;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=968;
            dmg=121;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=880;
            dmg=100;
        }
    }
}
