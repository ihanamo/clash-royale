package sample;

import java.net.URL;

public class Archer extends Troops{
    Archer(String url) {
        super(125.0,33.0,100.0,url,1.2,Place.AIRandGROUND,Place.GROUND);
        if(Controller.player.getXp()>2499)
        {
            hp=182;
            dmg=58;
        }
        else
            if(Controller.player.getXp()>1699)
            {
                hp=166;
                dmg=53;
            }
            else
                if(Controller.player.getXp()>899)
                {
                    hp=151;
                    dmg=48;
                }
                else
                    if(Controller.player.getXp()>499)
                    {
                        hp=127;
                        dmg=44;
                    }
        speed=0.33;
    }
//    public void updateXp()
//    {
//        this.xp+=xp;
//        if(xp>)
//    }
}
