import java.util.*;

public class Test {
    public static void main(String[] args){
        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(3);

        // System.out.println(Util.canColorEntireRow(5, new ArrayList<Integer>(seq)));

        ArrayList<String> coloredLigne = new ArrayList<String>();
        coloredLigne.add("Empty");
        coloredLigne.add("Empty");
        coloredLigne.add("White");
        coloredLigne.add("White");
        coloredLigne.add("White");

        System.out.println(Util.canColorEntireRow2(4, new ArrayList<Integer>(seq), new ArrayList<String>(coloredLigne)));
    }
}
