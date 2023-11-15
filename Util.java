import java.util.*;

public class Util {
    public static boolean canColorEntireRow(int j, ArrayList<Integer> seq) { //1.1 Q4
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

    public static boolean canColorEntireRow2(int j, ArrayList<Integer> seq, ArrayList<String> ligne){
        int l = seq.size();
        if(l == 0){
            return !ligne.contains("Black");
        }

        if (l >= 1) {
            if (j < seq.get(l - 1) - 1) {
                return false;
            } 
            else if(j == seq.get(l - 1) - 1){
                if(ligne.contains("White")){
                    return false;
                }
                return l == 1;
            }
            else{
                if(ligne.get(ligne.size() - 1).equals("White") || ligne.get(ligne.size() - 1).equals("Empty")){
                    ArrayList<String> tmp = new ArrayList<String>(ligne);
                    tmp.remove(tmp.size() - 1);
                    return canColorEntireRow2(j - 1, new ArrayList<Integer>(seq), tmp);
                }
                else{
                    int sl = seq.get(l - 1);

                    if (!ligne.subList(j - sl + 1, j + 1).contains("White") && 
                    (ligne.get(j - sl).equals("White") || ligne.get(j - sl).equals("Empty"))) {
                        return canColorEntireRow2(j - sl - 1, new ArrayList<Integer>(seq.subList(0, l - 1)), new ArrayList<String>(ligne.subList(0, j - sl)));
                    }
                    
                    return false;
                }
            }
        }
        throw new RuntimeException("Invalid state");
    }
}
