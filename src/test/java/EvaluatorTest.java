import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by minyoung on 2017-06-20.
 */
public class EvaluatorTest {
    @Test
    public void Rank_2개가_동일한게_두쌍이면_투페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.CLUBS),
                new Card(4,Suit.DIAMONDS),
                new Card(13,Suit.SPADES),
                new Card(13,Suit.HEARTS),
                new Card(2,Suit.CLUBS)
        );
        Ranking result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.TwoPairs));
    }

    @Test
    public void Rank_2개가_동일한게_한쌍이면_원페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.CLUBS),
                new Card(4,Suit.DIAMONDS),
                new Card(8,Suit.SPADES),
                new Card(13,Suit.HEARTS),
                new Card(2,Suit.CLUBS)
        );
        Ranking result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.OnePair));
    }

}
