import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class alphaTest {

    @Test
    void testCase1() {
        String str1 = "ASD";
        String str2 = "DSA";

        Similarity similarity = new Similarity();
        assertEquals(40d, similarity.calculateDuplicatedAlpha(str1, str2));
    }

    @Test
    void testCase2() {
        String str1 = "A";
        String str2 = "BB";

        Similarity similarity = new Similarity();
        assertEquals(0, similarity.calculateDuplicatedAlpha(str1, str2));
    }

    @Test
    void testCase3() {
        String str1 = "AAABB";
        String str2 = "BAA";

        Similarity similarity = new Similarity();
        assertEquals(40, similarity.calculateDuplicatedAlpha(str1, str2));
    }

    @Test
    void testCase4() {
        String str1 = "AA";
        String str2 = "AAE";

        Similarity similarity = new Similarity();
        assertEquals(20, similarity.calculateDuplicatedAlpha(str1, str2));
    }

}
