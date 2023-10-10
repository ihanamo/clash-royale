package sample;

import java.io.Serializable;

public class BattleHistory implements Serializable {
public String history;
public String winner;
public String opponent;

    public BattleHistory(String history, String winner, String opponent) {
        this.history = history;
        this.winner = winner;
        this.opponent = opponent;
    }
}
