package sample;

public class Valkyrie extends Troops{
    public Valkyrie(String url) {
        super(880.0,120.0,20.0,url,1.5,Place.GROUND,Place.GROUND);
        number=1;
        hitSpd=1.5;
        hp=880;
        dmg=120;
        rng=80;
        speed=0.33;
        if(Controller.player.getXp()>2499)
        {
            hp=1284;
            dmg=175;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=1170;
            dmg=159;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=1064;
            dmg=145;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=968;
            dmg=132;
        }
    }
}
