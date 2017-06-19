import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 2017-06-19.
 */
public class DeckTest {

    @Test
    public void Deck2개의_총카드수는_104(){
        Deck deck = new Deck(2);
        int totalCard = deck.getTotalCard();
        assertThat(totalCard, is(104));
    }



}
