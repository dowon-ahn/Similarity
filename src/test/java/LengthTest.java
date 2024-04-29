import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void testSimilarity() {
        String str1 = "AA";
        String str2 = "AAE";

        Similarity sim = new Similarity();
        assertEquals(30d, sim.calculateScoreByLength(str1, str2));
    }


}