package sample;

import java.io.Serializable;

/**
 * The type Battle history.
 */
public class BattleHistory implements Serializable {
    /**
     * The History.
     */
    public String history;
    /**
     * The Winner.
     */
    public String winner;
    /**
     * The Opponent.
     */
    public String opponent;

    /**
     * Instantiates a new Battle history.
     *
     * @param history  the history
     * @param winner   the winner
     * @param opponent the opponent
     */
    public BattleHistory(String history, String winner, String opponent) {
        this.history = history;
        this.winner = winner;
        this.opponent = opponent;
    }
}
