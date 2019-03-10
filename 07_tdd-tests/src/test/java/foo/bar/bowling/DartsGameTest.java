package foo.bar.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DartsGameTest {

    DartsGame game = new DartsGame();

    @Test
    void testAllZeroGame() {
        Assertions.assertEquals(501, game.getScore());

    }

    @Test
    void testOneHIt() {
        Assertions.assertEquals(451,game.hit(15,TypeOfField.BULLSEYE));


    }
}
