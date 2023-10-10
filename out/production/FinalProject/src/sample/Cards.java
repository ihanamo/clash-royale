package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
public class Cards{
    public boolean isInRange=false;
    public double hitSpd;
    public double speed;
    double hp;
     double dmg;
     double rng;
     Place target,position;
     Date lastHit,build;
     ArrayList<CardXY> targets = new ArrayList<CardXY>();
    String url;

    public Cards(double hp, double dmg, double rng, String url,double hitSpd,Place target,Place position) {
        this.hp = hp;
        this.dmg = dmg;
        this.rng = rng;
        this.url = url;
        this.hitSpd=hitSpd;
        lastHit=new Date();
        this.target=target;
        this.position=position;
    }

    public String getUrl() {
        return url;
    }
}
