package sample;

public class Giant extends Troops{
    public Giant(String url) {
        super(2000,126.0,50.0,url,1.5,Place.BUILDING,Place.GROUND);
        number=1;
        hitSpd=1.5;
        hp=2000;
        dmg=126;
        rng=50;
        speed=0.2;
        if(Controller.player.getXp()>2499)
        {
            hp=2920;
            dmg=183;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=2660;
            dmg=167;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=2420;
            dmg=152;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=2200;
            dmg=138;
        }
    }
}
