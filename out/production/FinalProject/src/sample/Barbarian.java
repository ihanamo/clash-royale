package sample;

public class Barbarian extends Troops{
    public Barbarian(String url) {
        super(300.0,75,20,url,1.5,Place.GROUND,Place.GROUND);
        number=4;
        hitSpd=1.5;
        hp=300;
        dmg=75;
        rng=50;
        speed=0.33;
        if(Controller.player.getXp()>2499)
        {
            hp=480;
            dmg=109;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=438;
            dmg=99;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=363;
            dmg=90;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=330;
            dmg=82;
        }
    }
}
