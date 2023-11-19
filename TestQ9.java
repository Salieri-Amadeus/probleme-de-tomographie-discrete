import java.util.ArrayList;
public class TestQ9 {
    public static void main(String[] args){
        ArrayList<Integer> ligneSeq1 = new ArrayList<Integer>();
        ArrayList<Integer> ligneSeq2 = new ArrayList<Integer>();
        ArrayList<Integer> ligneSeq3 = new ArrayList<Integer>();
        ArrayList<Integer> ligneSeq4 = new ArrayList<Integer>();
        ArrayList<Integer> ligneSeq5 = new ArrayList<Integer>();

        ArrayList<Integer> colSeq1 = new ArrayList<Integer>();
        ArrayList<Integer> colSeq2 = new ArrayList<Integer>();
        ArrayList<Integer> colSeq3 = new ArrayList<Integer>();
        ArrayList<Integer> colSeq4 = new ArrayList<Integer>();
        ArrayList<Integer> colSeq5 = new ArrayList<Integer>();

        ligneSeq2.add(3);
        ligneSeq4.add(1);
        ligneSeq4.add(1);
        ligneSeq4.add(1);
        ligneSeq5.add(3);

        colSeq1.add(1);
        colSeq1.add(1);
        colSeq2.add(1);
        colSeq3.add(1);
        colSeq3.add(2);
        colSeq4.add(1);
        colSeq5.add(2);

        ArrayList<ArrayList<Integer>> ligSeqs = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> colSeqs = new ArrayList<ArrayList<Integer>>();
        ligSeqs.add(ligneSeq1);
        ligSeqs.add(ligneSeq2);
        ligSeqs.add(ligneSeq3);
        ligSeqs.add(ligneSeq4);
        ligSeqs.add(ligneSeq5);
        colSeqs.add(colSeq1);
        colSeqs.add(colSeq2);
        colSeqs.add(colSeq3);
        colSeqs.add(colSeq4);
        colSeqs.add(colSeq5);

        Grille g = new Grille(5, 5, ligSeqs, colSeqs);

        System.out.println(g);

        ColoreResult res = Util.coloration(g);

        System.out.println(res.getSuccess());
        System.out.println(res.getUpdatedGrille());


    }
}
