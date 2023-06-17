import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextManipulatorTest {

    String validText = "stand";
    String invalidText = "RavenClaw";
    String paragraph = "It takes a great deal of bravery to stand up to our enemies," +
            "but just as much to stand up to our friends";

    @Test
    void testFindTextInParagraph_returns_true() {

        TextManipulator textManipulator = new TextManipulator();
        assertTrue(textManipulator.findTextInParagraph(validText, paragraph));
    }

    @Test
    void testFindTextInParagraph_returns_false() {

        TextManipulator textManipulator = new TextManipulator();
        assertFalse(textManipulator.findTextInParagraph(invalidText, paragraph));
    }

    @Test
    void testCountTextInParagraph_returns_2() {

        TextManipulator textManipulator = new TextManipulator();
        assertEquals(2, textManipulator.countTextInParagraph(validText, paragraph));
    }

    @Test
    void testCountTextInParagraph_returns_0() {

        TextManipulator textManipulator = new TextManipulator();
        assertEquals(0, textManipulator.countTextInParagraph(invalidText, paragraph));
    }
}