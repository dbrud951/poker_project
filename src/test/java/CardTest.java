/**
 * Created by 정명용 on 2017-06-19.
 */
public class CardTest {
    public void 카드_7_스페이드 생성(){
        Card card = new Card(7, Suit.SPADE);
        assertThat(card.getRank(), is(7));
        assertThat(card.getSuit(), is(Suit.SPADE));
    }
}
