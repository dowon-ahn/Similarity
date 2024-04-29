public class Similarity {
    public double calculateScoreByLength(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int maxLength = Math.max(str1.length(), str2.length());

        if(maxLength >= minLength * 2){
            return 0;
        }

        double gap = maxLength - minLength;
        return (1 - (gap / minLength)) * 60;
    }
}
