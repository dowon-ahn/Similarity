import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void testCase1() {
        String str1 = "ASD";
        String str2 = "DSA";

        Similarity sim = new Similarity();
        assertEquals(60, sim.calculateScoreByLength(str1, str2));
    }

    @Test
    void testCase2() {
        String str1 = "A";
        String str2 = "BB";

        Similarity sim = new Similarity();
        assertEquals(0, sim.calculateScoreByLength(str1, str2));
    }

    @Test
    void testCase3() {
        String str1 = "AAABB";
        String str2 = "BAA";

        Similarity sim = new Similarity();
        assertEquals(20d, sim.calculateScoreByLength(str1, str2));
    }

    @Test
    void testCase4() {
        String str1 = "AA";
        String str2 = "AAE";

        Similarity sim = new Similarity();
        assertEquals(30, sim.calculateScoreByLength(str1, str2));
    }

}