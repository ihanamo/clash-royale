package sample;

public class Wizard extends Troops{
    public Wizard(String url) {
        super(340.0,130.0,80.0,url,1.7,Place.AIRandGROUND,Place.GROUND);
        number=1;
        hitSpd=1.7;
        hp=340;
        dmg=130;
        rng=80;
        speed=0.33;
        if(Controller.player.getXp()>2499)
        {
            hp=496;
            dmg=189;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=452;
            dmg=172;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=411;
            dmg=157;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=374;
            dmg=143;
        }
    }
}
