package sample;

public class Inferno extends Cards{
    public Inferno(String url) {
        super(500,200,55,url,0.0,Place.AIRandGROUND,Place.BUILDING);
        if(Controller.player.getXp()>2499)
        {
            hp=1168;
            dmg=600;
        }
        else
        if(Controller.player.getXp()>1699)
        {
            hp=1064;
            dmg=500;
        }
        else
        if(Controller.player.getXp()>899)
        {
            hp=968;
            dmg=450;
        }
        else
        if(Controller.player.getXp()>499)
        {
            hp=880;
            dmg=250;
        }
    }
}
