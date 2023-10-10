package sample;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Player.
 */
public class Player implements Serializable {
    private int gems,money,xp=0;
    private String user,pass,name,email;
    private ArrayList<String> deck=new ArrayList<String>();
    /**
     * The Battle histories.
     */
    public ArrayList<BattleHistory> battleHistories=new ArrayList<BattleHistory>();

    /**
     * Gets user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Gets pass.
     *
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Instantiates a new Player.
     *
     * @param user  the user
     * @param name  the name
     * @param pass  the pass
     * @param email the email
     */
    public Player(String user,String name,String pass,String email) {
        gems=0;
        xp=0;
        money=500;
        this.user=user;
        this.name=name;
        this.pass=pass;
        this.email=email;
    }

    /**
     * Sets deck.
     *
     * @param deck the deck
     */
    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }

    /**
     * Sets xp.
     *
     * @param n the n
     */
    public void setXp(int n)
{
    xp+=n;
}

    /**
     * Gets xp.
     *
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * Add history.
     *
     * @param battleHistory the battle history
     */
    public void addHistory(BattleHistory battleHistory)
    {
        battleHistories.add(battleHistory);
    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public ArrayList<String> getDeck() {
        return deck;
    }
}

