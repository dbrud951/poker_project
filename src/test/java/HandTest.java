import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by minyoung on 2017-06-19.
 */
public class HandTest {
    @Test
    public void 파이브카드_핸드_카드숫자는_5() {
        Deck deck = new Deck(1);
        Hand hand = new Hand(deck, PokerType.FIVE);
        assertThat(hand.getTotalCard(), is(5));
    }
}
