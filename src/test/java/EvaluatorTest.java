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
    public void RANK가_A로_시작하는_연속적인_숫자이면_백스트레이트다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(5,Suit.DIAMONDS),
                new Card(4,Suit.HEARTS),
                new Card(3,Suit.DIAMONDS),
                new Card(1,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS)
        );
        Ranking result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.BackStraight));
    }

    @Test
    public void RANK가_3개가동일하면_트리플이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10,Suit.DIAMONDS),
                new Card(10,Suit.HEARTS),
                new Card(5,Suit.DIAMONDS),
                new Card(10,Suit.CLUBS),
                new Card(2,Suit.DIAMONDS)
        );
        Ranking result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.ThreeOfaKind));
    }
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
