package sample;

/**
 * The type Buildings.
 */
public class Buildings extends Cards{
    /**
     * The Hit spd.
     */
    double hitSpd, /**
     * The Rng.
     */
    rng, /**
     * The Dur.
     */
    dur, /**
     * The Hp.
     */
    hp, /**
     * The Dmg.
     */
    dmg;

    /**
     * Instantiates a new Buildings.
     *
     * @param hp       the hp
     * @param dmg      the dmg
     * @param rng      the rng
     * @param url      the url
     * @param hitSpd   the hit spd
     * @param target   the target
     * @param position the position
     */
    Buildings(double hp,double dmg ,double rng,String url,double hitSpd,Place target,Place position) {
        super(hp,dmg,rng,url,hitSpd,target,position);
    }
}
