import java.lang.reflect.Array;
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

    // public static boolean canColorEntireRow2(int j, ArrayList<Integer> seq, ArrayList<String> ligne){
    //     int l = seq.size();
    //     if(l == 0){
    //         return !ligne.contains("Black");
    //     }

    //     if (l >= 1) {
    //         if (j < seq.get(l - 1) - 1) {
    //             return false;
    //         } 
    //         else if(j == seq.get(l - 1) - 1){
    //             if(ligne.contains("White")){
    //                 return false;
    //             }
    //             return l == 1;
    //         }
    //         else{
    //             if(ligne.get(ligne.size() - 1).equals("White") || ligne.get(ligne.size() - 1).equals("Empty")){
    //                 ArrayList<String> tmp = new ArrayList<String>(ligne);
    //                 tmp.remove(tmp.size() - 1);
    //                 return canColorEntireRow2(j - 1, new ArrayList<Integer>(seq), tmp);
    //             }
    //             else{
    //                 int sl = seq.get(l - 1);

    //                 if (!ligne.subList(j - sl + 1, j + 1).contains("White") && 
    //                 (ligne.get(j - sl).equals("White") || ligne.get(j - sl).equals("Empty"))) {
    //                     return canColorEntireRow2(j - sl - 1, new ArrayList<Integer>(seq.subList(0, l - 1)), new ArrayList<String>(ligne.subList(0, j - sl)));
    //                 }
                    
    //                 return false;
    //             }
    //         }
    //     }
    //     throw new RuntimeException("Invalid state");
    // }

     public static boolean canColorEntireRow2(int j, ArrayList<Integer> seq, ArrayList<String> ligne){
        int l = seq.size();
        boolean b = false;
        if(l == 0){
            return !ligne.contains("Black");
        }

        if (l >= 1) {
            if (j < seq.get(l - 1) - 1) {
                b = b || false;
            } 
            else if(j == seq.get(l - 1) - 1){
                if(ligne.contains("White")){
                    b = b || false;
                }
                else{
                    b = b || (l == 1);
                }
            }
            else{
                if(ligne.get(ligne.size() - 1).equals("White") || ligne.get(ligne.size() - 1).equals("Empty")){
                    ArrayList<String> tmp = new ArrayList<String>(ligne);
                    tmp.remove(tmp.size() - 1);
                    b = b || canColorEntireRow2(j - 1, new ArrayList<Integer>(seq), tmp);
                }
                if(ligne.get(ligne.size() - 1).equals("Black") || ligne.get(ligne.size() - 1).equals("Empty")){
                    int sl = seq.get(l - 1);

                    if (!ligne.subList(j - sl + 1, j + 1).contains("White") && 
                    (ligne.get(j - sl).equals("White") || ligne.get(j - sl).equals("Empty"))) {
                        b = b || canColorEntireRow2(j - sl - 1, new ArrayList<Integer>(seq.subList(0, l - 1)), new ArrayList<String>(ligne.subList(0, j - sl)));
                    }
                    
                    b = b || false;
                }
            }
        }
        return b;
    }
    
    public static String determineCaseColor(int index, ArrayList<Integer> seq, ArrayList<String> ligne){
        //假设它是黑的
        ArrayList<String> ligneTmp = new ArrayList<String>(ligne);
        ligneTmp.set(index, "Black");
        boolean canBeBlack = canColorEntireRow2(ligneTmp.size() - 1, seq, ligneTmp);

        //假设它是白的
        ligneTmp = new ArrayList<String>(ligne);
        ligneTmp.set(index, "White");
        boolean canBeWhite = canColorEntireRow2(ligneTmp.size() - 1, seq, ligneTmp);

        if(canBeBlack && !canBeWhite) return "Black";
        if(!canBeBlack && canBeWhite) return "White";
        if(!canBeBlack && !canBeWhite) return "False";
        return "Empty";
    }

    public static boolean coloreLigne(Grille a, int index){
        ArrayList<Integer> seq = a.getLigSeqs().get(index);
        ArrayList<String> ligne = a.getLigne(index);

        for(int i = 0; i < ligne.size(); i++){
            if(ligne.get(i).equals("Empty")){
                String color = determineCaseColor(i, seq, ligne);
                if(color.equals("False")) return false;
                a.setCase(index, i, color);
            }
        }
        return true;
    }

    public static boolean coloreColonne(Grille a, int index){
        ArrayList<Integer> seq = a.getColSeqs().get(index);
        ArrayList<String> colonne = a.getColonne(index);

        for(int i = 0; i < colonne.size(); i++){
            if(colonne.get(i).equals("Empty")){
                String color = determineCaseColor(i, seq, colonne);
                if(color.equals("False")) return false;
                a.setCase(i, index, color);
            }
        }
        return true;
    }

    public static ColoreResult coloration(Grille a){
        Grille res = a.clone();
        ArrayList<Integer> ligneAVoir = new ArrayList<Integer>();
        ArrayList<Integer> colonneAVoir = new ArrayList<Integer>();

        for(int i = 0; i < res.getNbLig(); i++){
            ligneAVoir.add(i);
        }

        for(int i = 0; i < res.getNbCol(); i++){
            colonneAVoir.add(i);
        }

        while(!ligneAVoir.isEmpty() || !colonneAVoir.isEmpty()){
            ArrayList<Integer> nouveauxLigne = new ArrayList<Integer>();
            ArrayList<Integer> nouveauxColonne = new ArrayList<Integer>();
            ArrayList<Integer> ligneToDelete = new ArrayList<Integer>();
            ArrayList<Integer> colonneToDelete = new ArrayList<Integer>();

            for(int i: ligneAVoir){
                ArrayList<String> oldLigne = new ArrayList<String>(res.getLigne(i));
                ArrayList<String> ligne = res.getLigne(i);

                boolean b = coloreLigne(res, i);
                ligne = res.getLigne(i);
                if(!b){
                    return new ColoreResult("false", null);
                }
                else{
                    for(int j = 0; j < ligne.size(); j++){
                        if(!ligne.get(j).equals(oldLigne.get(j))){
                            nouveauxColonne.add(j);
                        }
                    }
                    for(int j: nouveauxColonne){
                        if(!colonneAVoir.contains(j)){
                            colonneAVoir.add(j);
                        }
                    }
                    ligneToDelete.add(i);
                }
            }
            ligneAVoir.removeAll(ligneToDelete);
            for(int i: colonneAVoir){
                ArrayList<String> oldColonne = new ArrayList<String>(res.getColonne(i));
                ArrayList<String> colonne = res.getColonne(i);

                boolean b = coloreColonne(res, i);
                colonne = res.getColonne(i);
                if(!b){
                    return new ColoreResult("false", null);
                }
                else{
                    for(int j = 0; j < colonne.size(); j++){
                        if(!colonne.get(j).equals(oldColonne.get(j))){
                            nouveauxLigne.add(j);
                        }
                    }
                    for(int j: nouveauxLigne){
                        if(!ligneAVoir.contains(j)){
                            ligneAVoir.add(j);
                        }
                    }
                    colonneToDelete.add(i);
                }
            }
            colonneAVoir.removeAll(colonneToDelete);
        }
        //检查grille中是否有empty
        for(int i = 0; i < res.getNbLig(); i++){
            for(int j = 0; j < res.getNbCol(); j++){
                if(res.getCase(i, j).equals("Empty")){
                    return new ColoreResult("ne sais pas", res);
                }
            }
        }

        return new ColoreResult("true", res);
    }

    
}
