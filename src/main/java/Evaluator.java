import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by minyoung on 2017-06-20.
 */
public class Evaluator {
    public Ranking evaluate(List<Card> cardList) {

        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        Map<Integer,Integer> tempMap2 = new HashMap<Integer, Integer>();
        List<Card> tempCard = cardList;
        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }

            if(tempMap2.containsKey(card.getRank())){
                Integer count = tempMap2.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap2.put(card.getRank(),count);
            }else{
                tempMap2.put(card.getRank(),new Integer(1));
            }
        }

        int sameCard = 0; //카드 한쌍(숫자 같은거) 갯수 세는 변수
        for (Integer key : tempMap2.keySet()) {
            if (tempMap2.get(key) == 2) {
                sameCard++;
            }
        }
        if (sameCard == 1) {
            return Ranking.OnePair;
        } else if (sameCard == 2) {
            return Ranking.TwoPairs;
        }
        return Ranking.Nopair;
    }
}
