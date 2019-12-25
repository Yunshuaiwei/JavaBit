import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author DELL
 * @Date 2019/12/24 13:47
 **/
public class Demo1 {
    public static void main(String[] args) {
        CardDemo cd = new CardDemo();
        List<Card> cards = cd.buyCard();
        System.out.println("-----------初始化扑克牌-----------");
        System.out.println(cards);
        System.out.println("---------------洗牌---------------");
        cd.swap(cards);
        System.out.println(cards);
        System.out.println("---------玩家手中的扑克牌----------");
        List<List<Card>> lists = cd.draw_Cards(cards);
        for (int i = 0; i <lists.size() ; i++) {
            System.out.println(i+1+"号玩家："+lists.get(i));
        }
        System.out.println("剩余牌的数量为："+cards.size()+"张！");
    }
}
class Card{
    private int rank;//牌面值
    private String suit;//花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String str=rank+"";
        switch (rank){
            case 11:
                str="J";
                break;
            case 12:
                str="Q";
                break;
            case 13:
                str="K";
                break;
        }
        return "[" + suit  +
                ":" + str + '\'' +
                ']';
    }
}
class CardDemo{
    static final String[] SUITS={"♥","♣","♦","♠"};
    /**
     * 初始化扑克牌
     * @return
     */
    public List<Card> buyCard(){
        List<Card> c=new ArrayList<>(52);
        for (int i = 0; i <4 ; i++) {
            for (int j = 1; j <14 ; j++) {
                Card card = new Card(j,SUITS[i]);
                c.add(card);
            }
        }
        return c;
    }
    /**
     * 交换扑克牌位置
     */
    public void swap(List<Card> cards){
        for (int i = cards.size()-1; i >0 ; i--) {
            Date date = new Date();
            long time = date.getTime();
            Random rand = new Random(time);
            int i1 = rand.nextInt(i);
            Card tmp= cards.get(i);
            cards.set(i,cards.get(i1));
            cards.set(i1,tmp);
        }
    }
    /**
     * 抓牌
     * @param cards
     */
    public List<List<Card>> draw_Cards(List<Card> cards){
        List<List<Card>> hands = new ArrayList<>(3);
        for (int i = 0; i <3 ; i++) {
            hands.add(new ArrayList<>(5));
        }
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> cards1 = hands.get(j);
                cards1.add(cards.remove(0));
            }
        }
        return hands;
    }
}
