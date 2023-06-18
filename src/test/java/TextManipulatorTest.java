import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextManipulatorTest {

    String validText = "stand";
    String invalidText = "RavenClaw";
    String paragraph = "It takes a great deal of bravery to stand up to our enemies, " +
            "but just as much to stand up to our friends";

    TextManipulator textManipulator = new TextManipulator();

    @Test
    void testFindTextInParagraph_returns_true() {
        assertTrue(textManipulator.findTextInParagraph(validText, paragraph));
    }

    @Test
    void testFindTextInParagraph_returns_false() {
        assertFalse(textManipulator.findTextInParagraph(invalidText, paragraph));
    }

    @Test
    void testCountTextInParagraph_returns_2() {
        assertEquals(2, textManipulator.countTextInParagraph(validText, paragraph));
    }

    @Test
    void testCountTextInParagraph_returns_0() {
        assertEquals(0, textManipulator.countTextInParagraph(invalidText, paragraph));
    }

    @Test
    void testRevertText_returns_reverted_string() {
        String revertedParagraph = "sdneirf ruo ot pu dnats ot hcum sa tsuj tub ,seimene ruo ot pu dnats ot yrevarb fo laed taerg a sekat tI";
        assertEquals(revertedParagraph, textManipulator.revertText(paragraph));
    }

    @Test
    void testFindCharInParagraph_returns_true() {
        assertTrue(textManipulator.findCharInParagraph('a', paragraph));
    }

    @Test
    void testFindCharInParagraph_returns_false() {
        assertFalse(textManipulator.findCharInParagraph('z', paragraph));
    }

    @Test
    void testCountCharInParagraph_returns_1() {
        assertEquals(1, textManipulator.countCharInParagraph('k', paragraph));
    }

    @Test
    void testCountCharInParagraph_returns_0() {
        assertEquals(0, textManipulator.countCharInParagraph('z', paragraph));
    }


}