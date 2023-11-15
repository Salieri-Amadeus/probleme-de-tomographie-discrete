import java.util.*;

public class Util {
    public static boolean canColorEntireRow(int j, ArrayList<Integer> seq) {
        int l = seq.size();
        if (l == 0) {
            return true;
        }

        if (l >= 1) {
            if (j < seq.get(l - 1) - 1) {
                return false;
            } 
            else if (j == seq.get(l - 1) - 1) {
                return l == 1;
            } 
            else {
                boolean b1 = canColorEntireRow(j - 1, new ArrayList<Integer>(seq));
                int sl = seq.get(l - 1);
                if (j - sl >= 0) {
                    seq.remove(l - 1);
                    boolean b2 = canColorEntireRow(j - sl - 1, seq);
                    return b1 || b2;
                }
                return b1;
            }
        }
        throw new RuntimeException("Invalid state");
    }
}
