package sample;

public class Peka extends Troops{
    public Peka(String url) {
        super(600,325.0,20.0,url,1.8,Place.GROUND,Place.GROUND);
        number=1;
        hitSpd=2;
        hp=600;
        dmg=325;
        rng=50;
        speed=0.5;
        if(Controller.player.getXp()>2499)
        {
            hp=876;
            dmg=474;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=798;
            dmg=432;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=726;
            dmg=393;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=660;
            dmg=357;
        }
    }
}
