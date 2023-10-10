package sample;

public class Spells extends Cards{
    int number,dur,dmg,rng;
    Spells(double hp,double dmg ,double rng,String url,double hitSpd,Place target,Place position) {
        super(hp,dmg,rng,url,hitSpd,Place.AIRandGROUND,Place.AIRandGROUND);
    }
}
