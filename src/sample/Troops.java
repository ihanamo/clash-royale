package sample;

/**
 * The type Troops.
 */
public class Troops extends Cards{
    /**
     * The Url.
     */
    String url;
    /**
     * The Is in range.
     */
    boolean isInRange=false;
    /**
     * The Number.
     */
    int number;

    /**
     * Instantiates a new Troops.
     *
     * @param hp       the hp
     * @param dmg      the dmg
     * @param rng      the rng
     * @param url      the url
     * @param hitSpd   the hit spd
     * @param target   the target
     * @param position the position
     */
    public Troops(double hp,double dmg ,double rng,String url,double hitSpd,Place target,Place position)
    {
        super(hp,dmg,rng,url,hitSpd,target,position);
    }
}
