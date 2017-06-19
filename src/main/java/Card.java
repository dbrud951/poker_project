/**
 * Created by 정명용 on 2017-06-19.
 */
import lombok.Data;

@Data
public class Card implements Comparable<Card>{

    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        if(rank>13){
            throw new NoSuchRankException();
        }
    }


    public int compareTo(Card o) {
        return this.getRank()-o.getRank();
    }
}
