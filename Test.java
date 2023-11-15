import java.util.*;

public class Test {
    public static void main(String[] args){
        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(1);
        seq.add(1);
        seq.add(2);

        System.out.println(Util.canColorEntireRow(5, seq));
    }
}
