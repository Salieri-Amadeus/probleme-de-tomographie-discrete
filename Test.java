import java.util.*;

public class Test {
    public static void main(String[] args){
        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(1);
        seq.add(1);
        seq.add(2);

        System.out.println(Util.canColorEntireRow(5, new ArrayList<Integer>(seq)));

        ArrayList<String> coloredLigne = new ArrayList<String>();
        coloredLigne.add("Black");
        coloredLigne.add("Empty");
        coloredLigne.add("Black");
        coloredLigne.add("White");
        coloredLigne.add("Black");
        coloredLigne.add("Black");
        coloredLigne.add("Black");

        System.out.println(Util.canColorEntireRow2(6, new ArrayList<Integer>(seq), new ArrayList<String>(coloredLigne)));

    }
}
