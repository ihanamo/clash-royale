package sample;

/**
 * The type Spells.
 */
public class Spells extends Cards{
    /**
     * The Number.
     */
    int number, /**
     * The Dur.
     */
    dur, /**
     * The Dmg.
     */
    dmg, /**
     * The Rng.
     */
    rng;

    /**
     * Instantiates a new Spells.
     *
     * @param hp       the hp
     * @param dmg      the dmg
     * @param rng      the rng
     * @param url      the url
     * @param hitSpd   the hit spd
     * @param target   the target
     * @param position the position
     */
    Spells(double hp,double dmg ,double rng,String url,double hitSpd,Place target,Place position) {
        super(hp,dmg,rng,url,hitSpd,Place.AIRandGROUND,Place.AIRandGROUND);
    }
}
