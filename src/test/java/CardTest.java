/**
 * Created by 정명용 on 2017-06-19.
 */

import org.junit.Test;

@Test
public class CardTest {
    public void 카드_7_스페이드 생성(){
        Card card = new Card(7, Suit.SPADES);
        assertThat(card.getRank(), is(7));
        assertThat(card.getSuit(), is(Suit.SPADES));
    }
}
