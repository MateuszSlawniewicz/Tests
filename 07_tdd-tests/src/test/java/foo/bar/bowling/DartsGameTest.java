package foo.bar.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DartsGameTest {


    @Test

    public void testAllZeroGame() {

        DartsGame game = new DartsGame();
        Assertions.assertEquals(501, game.getScore());

    }
}
