package foo.bar.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static foo.bar.bowling.TypeOfField.*;

public class DartsGameTest {

    DartsGame game = new DartsGame();

    @Test
    void testAllZeroGame() {
        Assertions.assertEquals(501, game.getScore());

    }

    @Test
    void testOneHIt() {
        Assertions.assertEquals(451, game.hit(15, BULLSEYE));
    }

    @Test
    void testTwoHits() {
        game.hit(15, BULLSEYE);
        game.hit(15, SINGLE);
        Assertions.assertEquals(436, game.getScore());


    }
}
