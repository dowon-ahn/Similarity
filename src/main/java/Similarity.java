import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Similarity {
    public double calculateScoreByLength(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int maxLength = Math.max(str1.length(), str2.length());

        if(checkOverDoubleLength(maxLength, minLength)){
            return 0;
        }

        double gap = maxLength - minLength;
        return (1 - (gap / minLength)) * 60;
    }

    private boolean checkOverDoubleLength(int maxLength, int minLength) {
        return maxLength >= minLength * 2;
    }

    public double calculateDuplicatedAlpha(String str1, String str2) {
        HashSet<Character> set1 = makeToHashSet(str1);
        HashSet<Character> set2 = makeToHashSet(str2);

        double totalCnt = getTotalCnt(set1, set2);
        if(totalCnt == str1.length() + str2.length()){
            return 0;
        }

        if(str1.length() == str2.length() && totalCnt == str1.length()){
            return 40;
        }


        double sameCnt = getSameCnt(set1, set2);

        return (sameCnt/totalCnt) * 40;
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
