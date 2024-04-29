import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityTest {

    @Test
    void testSimilarity() {
        String str1 = "AA";
        String str2 = "AAE";

        Similarity sim = new Similarity();
        assertEquals(30, sim.calculateScoreByLength(str1, str2));
    }

}