/**
 * Created by 정명용 on 2017-06-19.
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CardTest {

    @Test
    public void 카드_7_스페이드_생성() {
        Card card = new Card(7, Suit.SPADES);
        assertThat(card.getRank(), is(7));
        assertThat(card.getSuit(), is(Suit.SPADES));
    }

    @Test(expected = NoSuchRankException.class)
    public void 카드의_랭크는_13이하여야한다() {
        new Card(14, Suit.CLUBS);
    }

}
