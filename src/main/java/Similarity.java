import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Similarity {

    public static final int LENGTH_MIN_POINT = 0;
    public static final int LENGTH_MAX_POINT = 60;
    public static final int ALPHA_MAX_POINT = 40;

    public int calculateScoreByLength(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int maxLength = Math.max(str1.length(), str2.length());

        if(maxLength >= minLength * 2){
            return LENGTH_MIN_POINT;
        }

        int gap = maxLength - minLength;
        return LENGTH_MAX_POINT - (gap * LENGTH_MAX_POINT/ minLength);
    }

    private boolean checkOverDoubleLength(int maxLength, int minLength) {
        return maxLength >= minLength * 2;
    }

    public int calculateDuplicatedAlpha(String str1, String str2) {
        HashSet<Character> set1 = makeToHashSet(str1);
        HashSet<Character> set2 = makeToHashSet(str2);

        int totalCnt = getTotalCnt(set1, set2);
        if(totalCnt == str1.length() + str2.length()){
            return LENGTH_MIN_POINT;
        }

        if(str1.length() == str2.length() && totalCnt == str1.length()){
            return ALPHA_MAX_POINT;
        }


        int sameCnt = getSameCnt(set1, set2);

        return (sameCnt * ALPHA_MAX_POINT) / totalCnt;
    }

    private static HashSet<Character> makeToHashSet(String str1) {
        HashSet<Character> set1 = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set1.add(str1.charAt(i));
        }
        return set1;
    }

    private int getSameCnt(HashSet<Character> set1, HashSet<Character> set2) {
        Set<Character> copyOfSet1 = new HashSet<>(set1);

        copyOfSet1.retainAll(set2);
        return copyOfSet1.size();
    }

    private int getTotalCnt(HashSet<Character> set1, HashSet<Character> set2) {
        Set<Character> copyOfSet1 = new HashSet<>(set1);

        Iterator<Character> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            char c = iterator2.next();
            copyOfSet1.add(c);
        }

        return copyOfSet1.size();
    }
}
