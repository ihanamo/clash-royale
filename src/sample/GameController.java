package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.text.html.HTMLDocument;
import java.net.URL;
import java.util.*;

/**
 * The type Game controller.
 */
public class GameController implements Initializable {
    /**
     * The M.
     */
    int m = 3,
    /**
     * The S.
     */
    s = 0,
    /**
     * The .
     */
    i = 0,
    /**
     * The Elixirs.
     */
    elixirs = 0,
    /**
     * The Jj.
     */
    jj = -1,
    /**
     * The Jjj.
     */
    jjj = 0,
    /**
     * The Crowns 1.
     */
    crowns1 = 0,
    /**
     * The Crowns 2.
     */
    crowns2 = 0,
    /**
     * The Remove.
     */
    remove = -1;
    /**
     * The J.
     */
    double j = 0.0;
    /**
     * The Chosen card.
     */
    String chosenCard;
    private ArrayList<String> deck = null, alternativeDeck = new ArrayList<String>();
    private ArrayList<String> enemyDeck = new ArrayList<String>();
    private ArrayList<String> enemyAlternative = new ArrayList<String>();
    private ArrayList<String> wholeCards = new ArrayList<String>();
    private ArrayList<CardXY> cardsInGame = new ArrayList<CardXY>();
    private ArrayList<CardXY> enemyForce = new ArrayList<CardXY>();
    @FXML
    private Button game;
    @FXML
    private ProgressBar elixirBar;
    @FXML
    private Label elixirLabel, timeLabel, crownLabel;
    @FXML
    private ImageView gameDeck1, gameDeck2, gameDeck3, gameDeck4, gameDeck5;
    @FXML
    private Canvas canvas;
    /**
     * The Main pane.
     */
    @FXML
    public Pane mainPane,
    /**
     * The Up pane.
     */
    upPane,
    /**
     * The Down pane.
     */
    downPane;
    /**
     * The Gc.
     */
    GraphicsContext gc;
    @FXML
    private ImageView chosenCardImage;
    private final Image barbaru = new Image("/barbarU.png", 50, 50, false, false);
    private final Image barbard = new Image("/barbarD.png", 50, 50, false, false);
    private final Image wizardu = new Image("/wizardU.png", 50, 50, false, false);
    private final Image wizardd = new Image("/wizardD.png", 50, 50, false, false);
    private final Image miniu = new Image("/miniU.png", 50, 50, false, false);
    private final Image minid = new Image("/miniD.png", 50, 50, false, false);
    private final Image giantu = new Image("/giantU.png", 50, 50, false, false);
    private final Image giantd = new Image("/giantD.png", 50, 50, false, false);
    private final Image archeru = new Image("/archerU.png", 50, 50, false, false);
    private final Image archerd = new Image("/archerD.png", 50, 50, false, false);
    private final Image valku = new Image("/valkU.png", 50, 50, false, false);
    private final Image valkD = new Image("/valkD.png", 50, 50, false, false);
    private final Image dragonu = new Image("/dragonU.png", 50, 50, false, false);
    private final Image dragonD = new Image("/dragonD.png", 50, 50, false, false);
    private final Image barbaru2 = new Image("/barbarU2.png", 50, 50, false, false);
    private final Image barbard2 = new Image("/barbarD2.png", 50, 50, false, false);
    private final Image wizardu2 = new Image("/wizardU2.png", 50, 50, false, false);
    private final Image wizardd2 = new Image("/wizardD2.png", 50, 50, false, false);
    private final Image miniu2 = new Image("/miniU2.png", 50, 50, false, false);
    private final Image minid2 = new Image("/miniD2.png", 50, 50, false, false);
    private final Image giantu2 = new Image("/giantU2.png", 50, 50, false, false);
    private final Image giantd2 = new Image("/giantD2.png", 50, 50, false, false);
    private final Image archeru2 = new Image("/archerU2.png", 50, 50, false, false);
    private final Image archerd2 = new Image("/archerD2.png", 50, 50, false, false);
    private final Image valku2 = new Image("/valkU2.png", 50, 50, false, false);
    private final Image valkD2 = new Image("/valkD2.png", 50, 50, false, false);
    private final Image dragonu2 = new Image("/dragonU.png", 50, 50, false, false);
    private final Image dragonD2 = new Image("/dragonD.png", 50, 50, false, false);
    private final Image barbarHit = new Image("/barbar hit.png", 50, 50, false, false);
    private final Image wizardHit = new Image("/wizard hit.png", 50, 50, false, false);
    private final Image giantHit = new Image("/giant hit.png", 50, 50, false, false);
    private final Image archerHit = new Image("/archer hit.png", 50, 50, false, false);
    private final Image dragonHit = new Image("/dragon hit.png", 50, 50, false, false);
    private final Image valkyrieHit = new Image("/valkyrie hit.png", 50, 50, false, false);
    private final Image pekaHit = new Image("/peka hit.png", 50, 50, false, false);
    private final Image barbarHit2 = new Image("/barbar hit2.png", 50, 50, false, false);
    private final Image wizardHit2 = new Image("/wizard hit2.png", 50, 50, false, false);
    private final Image giantHit2 = new Image("/giant hit2.png", 50, 50, false, false);
    private final Image archerHit2 = new Image("/archer hit2.png", 50, 50, false, false);
    private final Image dragonHit2 = new Image("/dragon hit2.png", 50, 50, false, false);
    private final Image valkyrieHit2 = new Image("/valkyrie hit2.png", 50, 50, false, false);
    private final Image pekaHit2 = new Image("/peka hit2.png", 50, 50, false, false);
    private final Image babarImage = new Image("/barbarian_00000.png", 50, 50, false, false);
    private final Image wizardImage = new Image("/wizard_00000.png", 50, 50, false, false);
    private final Image pekaImage = new Image("/mini pekka_00000.png", 50, 50, false, false);
    private final Image infernoImage = new Image("/inferno_00000.png", 50, 50, false, false);
    private final Image giantImage = new Image("/giant_00000.png", 50, 50, false, false);
    private final Image arrowImage = new Image("/arrows_00000.png", 50, 50, false, false);
    private final Image archerImage = new Image("/archer_00000.png", 50, 50, false, false);
    private final Image valkyrieImage = new Image("/valkyrie_00000.png", 50, 50, false, false);
    private final Image rageImage = new Image("/rage_00000.png", 50, 50, false, false);
    private final Image canonImage = new Image("/canon_00000.png", 50, 50, false, false);
    private final Image fireBallImage = new Image("/fireball_00000.png", 50, 50, false, false);
    private final Image babyDragonImage = new Image("/baby dragon_00000.png", 50, 50, false, false);
    private final Image frame = new Image("/frame.png");
    private final Image fire = new Image("/fire.gif", 50, 50, false, false);
    private final Image babarImageBattle = new Image("/barbarian.png", 50, 50, false, false);
    private final Image wizardImageBattle = new Image("/wizard.png", 50, 50, false, false);
    private final Image pekaImageBattle = new Image("/mini pekka.png", 50, 50, false, false);
    private final Image infernoImageBattle = new Image("/inferno.png", 50, 50, false, false);
    private final Image giantImageBattle = new Image("/giant.png", 50, 50, false, false);
    private final Image archerImageBattle = new Image("/archer.png", 50, 50, false, false);
    private final Image valkyrieImageBattle = new Image("/valkyrie.png", 50, 50, false, false);
    private final Image canonImageBattle = new Image("/canon.png", 50, 50, false, false);
    private final Image fireBallImageBattle = new Image("/fireball.png", 50, 50, false, false);
    private final Image babyDragonImageBattle = new Image("/baby dragon.png", 50, 50, false, false);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = Controller.legends;
        gc = canvas.getGraphicsContext2D();
        wholeCards.add(babarImage.getUrl());
        wholeCards.add(wizardImage.getUrl());
        wholeCards.add(babarImage.getUrl());
        wholeCards.add(fireBallImage.getUrl());
        wholeCards.add(archerImage.getUrl());
        wholeCards.add(arrowImage.getUrl());
        wholeCards.add(giantImage.getUrl());
        wholeCards.add(valkyrieImage.getUrl());
        wholeCards.add(canonImage.getUrl());
        wholeCards.add(infernoImage.getUrl());
        wholeCards.add(rageImage.getUrl());
        wholeCards.add(pekaImage.getUrl());
    }

    @FXML
    private void game(ActionEvent event) {

        if (Controller.checked) {
            for (int i = 0; i < 8; i++) {
                int n;
                n = new Random().nextInt(wholeCards.size());
                enemyDeck.add(wholeCards.get(n));
                wholeCards.remove(n);
            }

            for (int i = 0; i < 5; i++) {
                int n;
                n = new Random().nextInt(enemyDeck.size());
                enemyAlternative.add(enemyDeck.get(n));
                enemyDeck.remove(n);
            }
        }
        for (int i = 0; i < 5; i++) {
            int n;
            n = new Random().nextInt(deck.size());
            alternativeDeck.add(deck.get(n));
            deck.remove(n);
        }

        enemyForce.add(new CardXY(new queenTower(null), null, null, null, 480, 25));
        enemyForce.add(new CardXY(new queenTower(null), null, null, null, 480, 280));
        enemyForce.add(new CardXY(new kingTower(null), null, null, null, 550, 150));
        cardsInGame.add(new CardXY(new queenTower(null), null, null, null, 90, 25));
        cardsInGame.add(new CardXY(new queenTower(null), null, null, null, 90, 280));
        cardsInGame.add(new CardXY(new kingTower(null), null, null, null, 20, 150));
        gameDeck1.setImage(new Image(alternativeDeck.get(0)));
        gameDeck2.setImage(new Image(alternativeDeck.get(1)));
        gameDeck3.setImage(new Image(alternativeDeck.get(2)));
        gameDeck4.setImage(new Image(alternativeDeck.get(3)));
        gameDeck5.setImage(new Image(alternativeDeck.get(4)));
        if (Controller.checked) {
            TimerTask timerTask2 = new TimerTask() {
                @Override
                public void run() {
                    int n = new Random().nextInt(enemyAlternative.size());
                    double x = 310, y = 280;
                    if (Controller.intelligence) {
                        int up = 0, down = 0;
                        for (int i = 0; i < cardsInGame.size(); i++) {
                            if (!(cardsInGame.get(i).card instanceof queenTower || cardsInGame.get(i).card instanceof kingTower))
                                if (new Point2D(cardsInGame.get(i).x, cardsInGame.get(i).y).distance(310, 25) < new Point2D(cardsInGame.get(i).x, cardsInGame.get(i).y).distance(310, 280)) {
                                    up++;
                                } else {
                                    down++;
                                }
                        }
                        if (up > down) {
                            x = (double) (new Random().nextInt(160)) + 310.0;
                            y = 25.0;
                        } else {
                            y = 280.0;
                            x = (double) (new Random().nextInt(160)) + 310.0;
                        }

                    } else {
                        y = new Random().nextInt(255) + 25;
                        x = new Random().nextInt(160) + 310;
                    }
                    if (enemyAlternative.get(n).equals(rageImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Rage(rageImage.getUrl()), rageImage.getUrl(), rageImage.getUrl(), rageImage.getUrl(), x, y));
                            for (int i=0;i<enemyForce.size();i++)
                            {
                                if(new Point2D(x,y).distance(enemyForce.get(i).x,enemyForce.get(i).y)<100);
                                {
                                    enemyForce.get(i).card.hitSpd*=1.4;
                                    enemyForce.get(i).card.dmg*=1.4;
                                }
                            }
                        }
                    } else if (enemyAlternative.get(n).equals(babarImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru2.getUrl(), barbard2.getUrl(), barbarHit2.getUrl(), x, y));
                            enemyForce.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru2.getUrl(), barbard2.getUrl(), barbarHit2.getUrl(), x + 20, y + 20));
                            enemyForce.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru2.getUrl(), barbard2.getUrl(), barbarHit2.getUrl(), x + 20, y));
                            enemyForce.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru2.getUrl(), barbard2.getUrl(), barbarHit2.getUrl(), x, y + 20));
                        }
                    } else if (enemyAlternative.get(n).equals(wizardImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Wizard(wizardImageBattle.getUrl()), wizardu2.getUrl(), wizardd2.getUrl(), wizardHit2.getUrl(), x, y));
                        }
                    } else if (enemyAlternative.get(n).equals(infernoImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Inferno(infernoImageBattle.getUrl()), infernoImageBattle.getUrl(), infernoImageBattle.getUrl(), infernoImageBattle.getUrl(), x, y));
                             enemyForce.get(enemyForce.size()-1).card.build=new Date();
                        }
                    } else if (enemyAlternative.get(n).equals(babyDragonImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new BabyDragon(babyDragonImageBattle.getUrl()), dragonu2.getUrl(), dragonD2.getUrl(), dragonHit2.getUrl(), x, y));

                        }
                    } else if (enemyAlternative.get(n).equals(archerImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Archer(archerImageBattle.getUrl()), archerd2.getUrl(), archeru2.getUrl(), archerHit2.getUrl(), x, y));
                            enemyForce.add(new CardXY(new Archer(archerImageBattle.getUrl()), archerd2.getUrl(), archeru2.getUrl(), archerHit2.getUrl(), x + 20, y + 20));

                        }
                    } else if (enemyAlternative.get(n).equals(arrowImage.getUrl())) {
                        {
                            x = new Random().nextInt(280);
                            y = new Random().nextInt(300);
                            enemyForce.add(new CardXY(new Arrow(arrowImage.getUrl()), arrowImage.getUrl(), arrowImage.getUrl(), arrowImage.getUrl(), x, y));
                            enemyForce.get(enemyForce.size() - 1).card.lastHit = new Date();
                            for (int i = 0; i < cardsInGame.size(); i++) {
                                if (new Point2D(cardsInGame.get(i).x, cardsInGame.get(i).y).distance(x, y) < 100) {
                                    cardsInGame.get(i).card.hp -= 150;
                                }
                            }
                        }
                    } else if (enemyAlternative.get(n).equals(giantImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Giant(giantImageBattle.getUrl()), giantd2.getUrl(), giantu2.getUrl(), giantHit2.getUrl(), x, y));

                        }
                    } else if (enemyAlternative.get(n).equals(valkyrieImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Valkyrie(valkyrieImageBattle.getUrl()), valkD2.getUrl(), valku2.getUrl(), valkyrieHit2.getUrl(), x, y));

                        }
                    } else if (enemyAlternative.get(n).equals(pekaImage.getUrl())) {

                        {
                            enemyForce.add(new CardXY(new Peka(pekaImageBattle.getUrl()), minid2.getUrl(), miniu2.getUrl(), pekaHit2.getUrl(), x, y));
                        }
                    } else if (enemyAlternative.get(n).equals(canonImage.getUrl())) {
                        {
                            enemyForce.add(new CardXY(new Canon(canonImageBattle.getUrl()), canonImageBattle.getUrl(), canonImageBattle.getUrl(), canonImageBattle.getUrl(), x, y));
                             enemyForce.get(enemyForce.size()-1).card.build=new Date();
                        }
                    } else if (enemyAlternative.get(n).equals(fireBallImage.getUrl())) {
                        {
                            x = new Random().nextInt(280);
                            y = new Random().nextInt(300);
                            enemyForce.add(new CardXY(new FireBall(fireBallImageBattle.getUrl()), fireBallImageBattle.getUrl(), fireBallImageBattle.getUrl(), fireBallImageBattle.getUrl(), x, y));
                            enemyForce.get(enemyForce.size() - 1).card.lastHit = new Date();
                            for (int i = 0; i < cardsInGame.size(); i++) {
                                if (new Point2D(cardsInGame.get(i).x, cardsInGame.get(i).y).distance(x, y) < 100) {
                                    cardsInGame.get(i).card.hp -= 200;
                                }
                            }
                        }
                    }
                    enemyAlternative.add(enemyDeck.get(new Random().nextInt(enemyDeck.size())));
                    enemyDeck.add(enemyAlternative.get(n));
                    enemyAlternative.remove(n);
                }
            };

            Timer t2 = new Timer();
            t2.schedule(timerTask2, 5000, 5000);
        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                s--;
                if (m == 0)
                    i += 2;
                else
                    i++;
                if (i > 1 && elixirs > 9)
                    i = 0;
                if (i == 2 && elixirs < 10) {
                    i = 0;
                    elixirs++;
                    Platform.runLater(() -> elixirBar.setProgress((double) elixirs / 10));
                    Platform.runLater(() -> elixirLabel.setText(String.valueOf(elixirs)));
                }
                if (s < 0) {
                    m--;
                    s += 60;
                }
                if (s < 10)
                    Platform.runLater(() -> timeLabel.setText(m + ":0" + s));
                else
                    Platform.runLater(() -> timeLabel.setText(m + ":" + s));
                if (m == 0 && s == 0)
                    this.cancel();
                j += 0.5;
                if (j > 5000)
                    j = 0;

            }
        };
        Timer t = new Timer();
        t.schedule(timerTask, 1000, 1000);
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            double t = 0;

            public void handle(long currentNanoTime) {
                jj++;
                jjj++;
                if (m == 2 && s > 50)
                    t = (currentNanoTime - startNanoTime) / 10000000000.0;
                gc.drawImage(new Image("/ground.png", 653, 400, false, false), 0, 0);
                //ruined castles
                for (int i=0;i<enemyForce.size();i++)
                {
                    if(enemyForce.get(i).card instanceof queenTower || enemyForce.get(i).card instanceof kingTower)
                        if(enemyForce.get(i).card.hp<1)
                            gc.drawImage(fire,enemyForce.get(i).x,enemyForce.get(i).y);
                }
                for (int i=0;i<cardsInGame.size();i++)
                {
                    if(cardsInGame.get(i).card instanceof queenTower || cardsInGame.get(i).card instanceof kingTower)
                        if(cardsInGame.get(i).card.hp<1)
                            gc.drawImage(fire,cardsInGame.get(i).x,cardsInGame.get(i).y);
                }
                for (int i = 0; i < cardsInGame.size(); i++) {
                    if (cardsInGame.get(i).card instanceof FireBall || cardsInGame.get(i).card instanceof Arrow)
                        if (new Date().getTime() - cardsInGame.get(i).card.lastHit.getTime() < 1000)
                            gc.drawImage(arrowImage, cardsInGame.get(i).x, cardsInGame.get(i).y);
                }
                for (int i = 0; i < enemyForce.size(); i++) {
                    if (enemyForce.get(i).card instanceof FireBall || enemyForce.get(i).card instanceof Arrow)
                        if (new Date().getTime() - enemyForce.get(i).card.lastHit.getTime() < 1000)
                            gc.drawImage(arrowImage, enemyForce.get(i).x, enemyForce.get(i).y);
                }
                        int remove2=-1;
                for (int i=0;i<cardsInGame.size();i++)
                {
                    if(cardsInGame.get(i).card instanceof Inferno ||cardsInGame.get(i).card instanceof Canon)
                        if(new Date().getTime()-(cardsInGame.get(i).card.build.getTime())>30000)
                            remove2=i;
                }
                if(remove2!=-1)
                {
                    cardsInGame.remove(remove2);
                    remove2=-1;
                }
                for (int i=0;i<enemyForce.size();i++)
                {
                    if(enemyForce.get(i).card instanceof Inferno ||enemyForce.get(i).card instanceof Canon)
                        if(new Date().getTime()-(enemyForce.get(i).card.build.getTime())>30000)
                            remove2=i;
                }
                if(remove2!=-1)
                {
                    enemyForce.remove(remove2);
                    remove2=-1;
                }
                //army shooting
                for (int o = 0; o < cardsInGame.size(); o++) {
                    for (int oo = 0; oo < enemyForce.size(); oo++) {

                        if (new Point2D(cardsInGame.get(o).x, cardsInGame.get(o).y).distance(new Point2D(enemyForce.get(oo).x, enemyForce.get(oo).y)) < cardsInGame.get(o).card.rng)
                            if((cardsInGame.get(o).card.target==(Place.AIRandGROUND))||cardsInGame.get(o).card.position==(Place.AIRandGROUND)||(cardsInGame.get(o).card.position==(Place.BUILDING))||(cardsInGame.get(o).card.target==(Place.GROUND)&&enemyForce.get(oo).card.position==(Place.GROUND))||(enemyForce.get(oo).card.position==(Place.BUILDING)))
                            {
                                cardsInGame.get(o).card.isInRange = true;
                            if (!(cardsInGame.get(o).card instanceof queenTower || cardsInGame.get(o).card instanceof kingTower)) {
                                if (jj < 15)
                                    gc.drawImage(new Image(cardsInGame.get(o).hitPic, 50, 50, false, false), cardsInGame.get(o).x, cardsInGame.get(o).y);
                                else
                                    gc.drawImage(new Image(cardsInGame.get(o).uPic, 50, 50, false, false), cardsInGame.get(o).x, cardsInGame.get(o).y);
                            }
                            if (!cardsInGame.get(o).card.targets.contains(enemyForce.get(oo)))
                                cardsInGame.get(o).card.targets.add(enemyForce.get(oo));
                            if ((double) ((new Date().getTime() - cardsInGame.get(o).card.lastHit.getTime()) / 1000) > cardsInGame.get(o).card.hitSpd) {
                                enemyForce.get(oo).card.hp -= cardsInGame.get(o).card.dmg;
                                cardsInGame.get(o).card.lastHit = new Date();
                            }
                            if (jj < 10)
                                gc.drawImage(fire, enemyForce.get(oo).x, enemyForce.get(oo).y);
                            if (enemyForce.get(oo).card.hp < 1) {
                                for (int i = 0; i < cardsInGame.size(); i++)
                                    if (cardsInGame.get(i).card.targets.contains(enemyForce.get(oo)))
                                        cardsInGame.get(i).card.targets.remove(enemyForce.get(oo));
                                cardsInGame.get(o).card.isInRange = false;
                                if (enemyForce.get(oo).card instanceof queenTower || enemyForce.get(oo).card instanceof kingTower) {
                                    if (enemyForce.get(oo).card instanceof queenTower && enemyForce.get(oo).card.getUrl() == null) {
                                        crowns1++;
                                        Platform.runLater(() -> crownLabel.setText(String.valueOf(1 + Integer.parseInt(crownLabel.getText()))));
                                    }
                                    if (enemyForce.get(oo).card instanceof kingTower)
                                    {
                                        crowns1=3;
                                        Platform.runLater(() -> crownLabel.setText("3"));
                                    }
                                    if (crowns1 == 3 ) {
                                        setWinner();
                                        stop();
                                    }
                                    if(m==0&&s==0)
                                        if(crowns1!=crowns2)
                                        {
                                            setWinner();
                                            stop();
                                        }
                                }
                                enemyForce.get(oo).card.url = fire.getUrl();
                                remove = oo;
                            }
                        }
                    }
                    if (remove != -1) {
                        enemyForce.remove(remove);
                        remove = -1;
                    }
                }
                for (int i = 0; i < cardsInGame.size(); i++)
                    if (cardsInGame.get(i).card.targets.size() == 0)
                        cardsInGame.get(i).card.isInRange = false;
                //enemy shooting
                for (int o = 0; o < enemyForce.size(); o++) {
                    for (int oo = 0; oo < cardsInGame.size(); oo++) {

                        if (new Point2D(enemyForce.get(o).x, enemyForce.get(o).y).distance(new Point2D(cardsInGame.get(oo).x, cardsInGame.get(oo).y)) < enemyForce.get(o).card.rng)
                            if((enemyForce.get(o).card.target==(Place.AIRandGROUND))||enemyForce.get(o).card.position==(Place.AIRandGROUND)||(enemyForce.get(o).card.position==(Place.BUILDING))||(enemyForce.get(o).card.target==(Place.GROUND)&&cardsInGame.get(oo).card.position==(Place.GROUND))||(cardsInGame.get(oo).card.position==(Place.BUILDING)))
                            {
                            enemyForce.get(o).card.isInRange = true;
                            if (!(enemyForce.get(o).card instanceof queenTower || enemyForce.get(o).card instanceof kingTower)) {
                                if (jj < 15)
                                    gc.drawImage(new Image(enemyForce.get(o).hitPic, 50, 50, false, false), enemyForce.get(o).x, enemyForce.get(o).y);
                                else
                                    gc.drawImage(new Image(enemyForce.get(o).uPic, 50, 50, false, false), enemyForce.get(o).x, enemyForce.get(o).y);
                            }

                            if (!enemyForce.get(o).card.targets.contains(cardsInGame.get(oo)))
                                enemyForce.get(o).card.targets.add(cardsInGame.get(oo));
                            //System.out.println((double)((new Date().getTime()-cardsInGame.get(o).card.lastHit.getTime())/1000));
                            if ((double) ((new Date().getTime() - enemyForce.get(o).card.lastHit.getTime()) / 1000) > enemyForce.get(o).card.hitSpd) {
                                cardsInGame.get(oo).card.hp -= enemyForce.get(o).card.dmg;
                                enemyForce.get(o).card.lastHit = new Date();
                            }
                            if (jj < 10)
                                gc.drawImage(fire, cardsInGame.get(oo).x, cardsInGame.get(oo).y);
                            if (cardsInGame.get(oo).card.hp < 1) {
                                for (int i = 0; i < enemyForce.size(); i++)
                                    if (enemyForce.get(i).card.targets.contains(cardsInGame.get(oo)))
                                        enemyForce.get(i).card.targets.remove(cardsInGame.get(oo));
                                enemyForce.get(o).card.isInRange = false;
                                if (cardsInGame.get(oo).card instanceof queenTower || cardsInGame.get(oo).card instanceof kingTower) {
                                    if (cardsInGame.get(oo).card instanceof queenTower && cardsInGame.get(oo).card.getUrl() == null)
                                        crowns2++;
                                    if (cardsInGame.get(oo).card instanceof kingTower)
                                        crowns2 = 3;
                                    if (crowns2 == 3) {
                                        setWinner();
                                        stop();
                                    }
                                    if(m==0&&s==0)
                                        if(crowns1!=crowns2)
                                        {
                                            setWinner();
                                            stop();
                                        }
                                }
                                cardsInGame.get(oo).card.url = fire.getUrl();
                                remove = oo;
                            }
                        }
                    }
                    if (remove != -1) {
                        cardsInGame.remove(remove);
                        remove = -1;
                    }
                }
                for (int i = 0; i < enemyForce.size(); i++)
                    if (enemyForce.get(i).card.targets.size() == 0)
                        enemyForce.get(i).card.isInRange = false;
                //army drawing
                for (int o = 0; o < cardsInGame.size(); o++) {
                    if (cardsInGame.get(o).card.isInRange || cardsInGame.get(o).card instanceof Rage || cardsInGame.get(o).card instanceof Arrow || cardsInGame.get(o).card instanceof Inferno || cardsInGame.get(o).card instanceof Canon || cardsInGame.get(o).card instanceof FireBall || cardsInGame.get(o).card instanceof queenTower || cardsInGame.get(o).card instanceof kingTower) {

                    } else if (cardsInGame.get(o).x < 550) {
                        double speed = ((Troops) cardsInGame.get(o).card).speed;
                        if (cardsInGame.get(o).x < 280 || cardsInGame.get(o).x > 310 && (cardsInGame.get(o).y < 260 && cardsInGame.get(o).y > 250))
                            cardsInGame.get(o).x = cardsInGame.get(o).x + t * speed;
                        else {
                            if (cardsInGame.get(o).y > 200 && cardsInGame.get(o).y < 280)
                                cardsInGame.get(o).y = cardsInGame.get(o).y + t * speed;
                            else if (cardsInGame.get(o).y < 200 && cardsInGame.get(o).y > 30)
                                cardsInGame.get(o).y = cardsInGame.get(o).y - t * speed;
                            else
                                cardsInGame.get(o).x = cardsInGame.get(o).x + t * speed;
                        }
                    } else {
                        double speed = ((Troops) cardsInGame.get(o).card).speed;
                        if (cardsInGame.get(o).y < 150)
                            cardsInGame.get(o).y = cardsInGame.get(o).y + t * speed;
                        else
                            cardsInGame.get(o).y = cardsInGame.get(o).y - t * speed;
                    }
                    if (!(cardsInGame.get(o).card instanceof queenTower || cardsInGame.get(o).card instanceof kingTower) && !cardsInGame.get(o).card.isInRange) {
                        if (jj < 15)
                            gc.drawImage(new Image(cardsInGame.get(o).dPic, 50, 50, false, false), cardsInGame.get(o).x, cardsInGame.get(o).y);
                        else
                            gc.drawImage(new Image(cardsInGame.get(o).uPic, 50, 50, false, false), cardsInGame.get(o).x, cardsInGame.get(o).y);
                    }
                }
                //enemy drawing
                for (int o = 0; o < enemyForce.size(); o++) {
                    if (enemyForce.get(o).card.isInRange || enemyForce.get(o).card instanceof Rage || enemyForce.get(o).card instanceof Arrow || enemyForce.get(o).card instanceof Inferno || enemyForce.get(o).card instanceof Canon || enemyForce.get(o).card instanceof FireBall || enemyForce.get(o).card instanceof queenTower || enemyForce.get(o).card instanceof kingTower) {

                    } else if (enemyForce.get(o).x > 50) {
                        double speed = ((Troops) enemyForce.get(o).card).speed;
                        if (enemyForce.get(o).x < 280 || enemyForce.get(o).x > 310 && (enemyForce.get(o).y < 260 && enemyForce.get(o).y > 250))
                            enemyForce.get(o).x = enemyForce.get(o).x - t * speed;
                        else {
                            if (enemyForce.get(o).y > 200 && enemyForce.get(o).y < 280)
                                enemyForce.get(o).y = enemyForce.get(o).y + t * speed;
                            else if (enemyForce.get(o).y < 200 && enemyForce.get(o).y > 30)
                                enemyForce.get(o).y = enemyForce.get(o).y - t * speed;
                            else
                                enemyForce.get(o).x = enemyForce.get(o).x - t * speed;
                        }
                    } else {
                        double speed = ((Troops) enemyForce.get(o).card).speed;
                        if (enemyForce.get(o).y < 150)
                            enemyForce.get(o).y = enemyForce.get(o).y + t * speed;
                        else
                            enemyForce.get(o).y = enemyForce.get(o).y - t * speed;
                    }
                    if (!(enemyForce.get(o).card instanceof queenTower || enemyForce.get(o).card instanceof kingTower) && !enemyForce.get(o).card.isInRange) {
                        if (jj < 15)
                            gc.drawImage(new Image(enemyForce.get(o).dPic, 50, 50, false, false), enemyForce.get(o).x, enemyForce.get(o).y);
                        else
                            gc.drawImage(new Image(enemyForce.get(o).uPic, 50, 50, false, false), enemyForce.get(o).x, enemyForce.get(o).y);
                    }
                }
                if (jj > 30)
                    jj = 0;
                if (jjj > 150)
                    jjj = 0;
            }
        }.start();
    }

    private void setWinner() {

        if (Integer.parseInt(crownLabel.getText()) > crowns2) {
            Controller.player.addHistory(new BattleHistory(Calendar.getInstance().getTime().toString(),"you","bot"));Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setMinWidth(250);
            stage.setTitle("Congrats");
            Label label = new Label();
            label.setText("You Won");
            Button button = new Button("Ok");
            button.setOnAction(e -> {
                stage.close();
            });
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();
        } else {
            Controller.player.addHistory(new BattleHistory(Calendar.getInstance().getTime().toString(),"bot","bot"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setMinWidth(250);
            stage.setTitle("Congrats");
            Label label = new Label();
            label.setText("You Lose");
            Button button = new Button("Ok");
            button.setOnAction(e -> {
                stage.close();
            });
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();
        }
        if(crowns2<crowns1)
            Controller.player.setXp(200);
        else
            Controller.player.setXp(70);
        Main.changeSceneToMainMenu();
    }

    /**
     * Game deck 1.
     *
     * @param mouseEvent the mouse event
     */
    @FXML
    public void gameDeck1(MouseEvent mouseEvent) {
        if (gameDeck1.getImage().getUrl().equals(archerImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = archerImage.getUrl();
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck1.setImage(gameDeck5.getImage());
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(arrowImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = arrowImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(babyDragonImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = babyDragonImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(babarImage.getUrl())) {
            if (elixirs > 5) {
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCard = babarImage.getUrl();
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        } else if (gameDeck1.getImage().getUrl().equals(fireBallImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = fireBallImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(canonImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = canonImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(giantImage.getUrl())) {
            if (elixirs > 4) {
                chosenCard = giantImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        } else if (gameDeck1.getImage().getUrl().equals(pekaImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = pekaImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(rageImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = rageImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(valkyrieImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = valkyrieImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(wizardImage.getUrl())) {
            if (elixirs > 4) {
                chosenCard = wizardImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        } else if (gameDeck1.getImage().getUrl().equals(infernoImage.getUrl())) {
            if (elixirs > 4) {
                chosenCard = infernoImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        }
    }

    /**
     * Game deck 2.
     *
     * @param event the event
     */
    @FXML
    public void gameDeck2(MouseEvent event) {
        if (gameDeck2.getImage().getUrl().equals(archerImage.getUrl()) && elixirs > 2) {
            chosenCard = archerImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(arrowImage.getUrl()) && elixirs > 2) {
            chosenCard = arrowImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(babyDragonImage.getUrl()) && elixirs > 3) {
            chosenCard = babyDragonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(babarImage.getUrl()) && elixirs > 4) {
            chosenCard = babarImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck2.getImage().getUrl().equals(fireBallImage.getUrl()) && elixirs > 3) {
            chosenCard = fireBallImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(canonImage.getUrl()) && elixirs > 2) {
            chosenCard = canonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(giantImage.getUrl()) && elixirs > 4) {
            chosenCard = giantImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck2.getImage().getUrl().equals(pekaImage.getUrl()) && elixirs > 3) {
            chosenCard = pekaImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(rageImage.getUrl()) && elixirs > 2) {
            chosenCard = rageImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck2.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(valkyrieImage.getUrl()) && elixirs > 3) {
            chosenCard = valkyrieImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(wizardImage.getUrl()) && elixirs > 4) {
            chosenCard = wizardImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck2.getImage().getUrl().equals(infernoImage.getUrl()) && elixirs > 4) {
            chosenCard = infernoImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        }
    }

    /**
     * Game deck 3.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void gameDeck3(MouseEvent actionEvent) {
        if (gameDeck3.getImage().getUrl().equals(archerImage.getUrl()) && elixirs > 2) {
            chosenCard = archerImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck3.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck3.getImage().getUrl().equals(arrowImage.getUrl()) && elixirs > 2) {
            chosenCard = arrowImage.getUrl();
            gameDeck3.setImage(gameDeck5.getImage());
            elixirs -= 3;
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
        } else if (gameDeck3.getImage().getUrl().equals(babyDragonImage.getUrl()) && elixirs > 3) {
            chosenCard = babyDragonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(babarImage.getUrl()) && elixirs > 4) {
            chosenCard = babarImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck3.getImage().getUrl().equals(fireBallImage.getUrl()) && elixirs > 3) {
            chosenCard = fireBallImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(canonImage.getUrl()) && elixirs > 2) {
            chosenCard = canonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck3.getImage().getUrl().equals(giantImage.getUrl()) && elixirs > 4) {
            chosenCard = giantImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck3.getImage().getUrl().equals(pekaImage.getUrl()) && elixirs > 3) {
            chosenCard = pekaImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(rageImage.getUrl()) && elixirs > 2) {
            chosenCard = rageImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck3.getImage().getUrl().equals(valkyrieImage.getUrl()) && elixirs > 3) {
            chosenCard = valkyrieImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(wizardImage.getUrl()) && elixirs > 4) {
            chosenCard = wizardImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck3.getImage().getUrl().equals(infernoImage.getUrl()) && elixirs > 4) {
            chosenCard = infernoImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            gameDeck3.setImage(gameDeck5.getImage());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        }
    }

    /**
     * Game deck 4.
     *
     * @param event the event
     */
    @FXML
    public void gameDeck4(MouseEvent event) {
        if (gameDeck4.getImage().getUrl().equals(archerImage.getUrl()) && elixirs > 2) {
            chosenCard = archerImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            gameDeck4.setImage(gameDeck5.getImage());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(arrowImage.getUrl()) && elixirs > 2) {
            chosenCard = arrowImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(babyDragonImage.getUrl()) && elixirs > 3) {
            chosenCard = babyDragonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck4.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(babarImage.getUrl()) && elixirs > 4) {
            chosenCard = babarImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            gameDeck4.setImage(gameDeck5.getImage());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck4.getImage().getUrl().equals(fireBallImage.getUrl()) && elixirs > 3) {
            chosenCard = fireBallImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(canonImage.getUrl()) && elixirs > 2) {
            chosenCard = canonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(giantImage.getUrl()) && elixirs > 4) {
            chosenCard = giantImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck4.getImage().getUrl().equals(pekaImage.getUrl()) && elixirs > 3) {
            chosenCard = pekaImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(rageImage.getUrl()) && elixirs > 2) {
            chosenCard = rageImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(valkyrieImage.getUrl()) && elixirs > 3) {
            chosenCard = valkyrieImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(wizardImage.getUrl()) && elixirs > 4) {
            chosenCard = wizardImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            elixirs -= 5;
            gameDeck4.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
        } else if (gameDeck4.getImage().getUrl().equals(infernoImage.getUrl()) && elixirs > 4) {
            chosenCard = infernoImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        }
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
     * Sets canvas.
     *
     * @param canvas the canvas
     */
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * Drop card.
     *
     * @param mouseEvent the mouse event
     */
    @FXML
    public void dropCard(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if (chosenCard.equals(rageImage.getUrl()) || chosenCard.equals(fireBallImage.getUrl()) || chosenCard.equals(arrowImage.getUrl())) {

        } else if (x < 280) {

        } else
            return;
        if (chosenCard != null)
            if (chosenCard.equals(rageImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Rage(rageImage.getUrl()), rageImage.getUrl(), rageImage.getUrl(), rageImage.getUrl(), x, y));
                    for (int i=0;i<cardsInGame.size();i++)
                    {
                        if(new Point2D(x,y).distance(cardsInGame.get(i).x,cardsInGame.get(i).y)<100);
                        {
                            cardsInGame.get(i).card.hitSpd*=1.4;
                            cardsInGame.get(i).card.dmg*=1.4;
                        }
                    }
                    chosenCardImage.setImage(frame);
                    chosenCard = null;
                }
            } else if (chosenCard.equals(babarImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru.getUrl(), barbard.getUrl(), barbarHit.getUrl(), x, y));
                    cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru.getUrl(), barbard.getUrl(), barbarHit.getUrl(), x + 20, y + 20));
                    cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru.getUrl(), barbard.getUrl(), barbarHit.getUrl(), x + 20, y));
                    cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()), barbaru.getUrl(), barbard.getUrl(), barbarHit.getUrl(), x, y + 20));
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(wizardImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Wizard(wizardImageBattle.getUrl()), wizardu.getUrl(), wizardd.getUrl(), wizardHit.getUrl(), x, y));
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(infernoImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Inferno(infernoImageBattle.getUrl()), infernoImageBattle.getUrl(), infernoImageBattle.getUrl(), infernoImageBattle.getUrl(), x, y));
                    cardsInGame.get(cardsInGame.size()-1).card.build=new Date();
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(babyDragonImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new BabyDragon(babyDragonImageBattle.getUrl()), dragonu.getUrl(), dragonD.getUrl(), dragonHit.getUrl(), x, y));
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(archerImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Archer(archerImageBattle.getUrl()), archerd.getUrl(), archeru.getUrl(), archerHit.getUrl(), x, y));
                    cardsInGame.add(new CardXY(new Archer(archerImageBattle.getUrl()), archerd.getUrl(), archeru.getUrl(), archerHit.getUrl(), x + 20, y + 20));
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(arrowImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Arrow(arrowImage.getUrl()), arrowImage.getUrl(), arrowImage.getUrl(), arrowImage.getUrl(), x, y));
                    cardsInGame.get(cardsInGame.size() - 1).card.lastHit = new Date();
                    for (int i = 0; i < enemyForce.size(); i++) {
                        if (new Point2D(enemyForce.get(i).x, enemyForce.get(i).y).distance(x, y) < 100) {
                            enemyForce.get(i).card.hp -= 150;
                        }
                    }
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(giantImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Giant(giantImageBattle.getUrl()), giantd.getUrl(), giantu.getUrl(), giantHit.getUrl(), x, y));
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(valkyrieImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Valkyrie(valkyrieImageBattle.getUrl()), valkD.getUrl(), valku.getUrl(), valkyrieHit.getUrl(), x, y));
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(pekaImage.getUrl()) && chosenCard != null) {

                {
                    cardsInGame.add(new CardXY(new Peka(pekaImageBattle.getUrl()), minid.getUrl(), miniu.getUrl(), pekaHit.getUrl(), x, y));
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(canonImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new Canon(canonImageBattle.getUrl()), canonImageBattle.getUrl(), canonImageBattle.getUrl(), canonImageBattle.getUrl(), x, y));
                    cardsInGame.get(cardsInGame.size()-1).card.build=new Date();
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            } else if (chosenCard.equals(fireBallImage.getUrl()) && chosenCard != null) {
                {
                    cardsInGame.add(new CardXY(new FireBall(fireBallImageBattle.getUrl()), fireBallImageBattle.getUrl(), fireBallImageBattle.getUrl(), fireBallImageBattle.getUrl(), x, y));
                    cardsInGame.get(cardsInGame.size() - 1).card.lastHit = new Date();
                    for (int i = 0; i < enemyForce.size(); i++) {
                        if (new Point2D(enemyForce.get(i).x, enemyForce.get(i).y).distance(x, y) < 100) {
                            enemyForce.get(i).card.hp -= 200;
                        }
                    }
                    chosenCard = null;
                    chosenCardImage.setImage(frame);
                }
            }
    }
}
