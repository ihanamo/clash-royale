package sample;

public class CardXY {
    Cards card;
    double x,y;
    String uPic,dPic,hitPic;
    public CardXY(Cards card,String uPic,String dPic,String hitPic, double x, double y) {
        this.card = card;
        this.x = x;
        this.y = y;
        this.dPic=dPic;
        this.uPic=uPic;
        this.hitPic=hitPic;
    }
}
