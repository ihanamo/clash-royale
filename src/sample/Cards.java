package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * The type Cards.
 */
public class Cards{
    /**
     * The Is in range.
     */
    public boolean isInRange=false;
    /**
     * The Hit spd.
     */
    public double hitSpd;
    /**
     * The Speed.
     */
    public double speed;
    /**
     * The Hp.
     */
    double hp;
    /**
     * The Dmg.
     */
    double dmg;
    /**
     * The Rng.
     */
    double rng;
    /**
     * The Target.
     */
    Place target, /**
     * The Position.
     */
    position;
    /**
     * The Last hit.
     */
    Date lastHit, /**
     * The Build.
     */
    build;
    /**
     * The Targets.
     */
    ArrayList<CardXY> targets = new ArrayList<CardXY>();
    /**
     * The Url.
     */
    String url;

    /**
     * Instantiates a new Cards.
     *
     * @param hp       the hp
     * @param dmg      the dmg
     * @param rng      the rng
     * @param url      the url
     * @param hitSpd   the hit spd
     * @param target   the target
     * @param position the position
     */
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

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }
}
