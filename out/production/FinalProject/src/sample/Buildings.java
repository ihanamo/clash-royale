package sample;

public class Buildings extends Cards{
    double hitSpd,rng,dur,hp,dmg;
    Buildings(double hp,double dmg ,double rng,String url,double hitSpd,Place target,Place position) {
        super(hp,dmg,rng,url,hitSpd,target,position);
    }
}
