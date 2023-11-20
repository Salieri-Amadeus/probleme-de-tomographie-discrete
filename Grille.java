import java.util.ArrayList;

public class Grille implements Cloneable {
    private int nbLig;
    private int nbCol;
    private ArrayList<ArrayList<Integer>> ligSeqs;
    private ArrayList<ArrayList<Integer>> colSeqs;
    private ArrayList<ArrayList<String>> cases;

    public Grille(int nbLig, int nbCol, ArrayList<ArrayList<Integer>> ligSeqs, ArrayList<ArrayList<Integer>> colSeqs){
        this.nbLig = nbLig;
        this.nbCol = nbCol;
        this.ligSeqs = ligSeqs;
        this.colSeqs = colSeqs;
        this.cases = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < nbLig; i++){
            ArrayList<String> tmp = new ArrayList<String>();
            for(int j = 0; j < nbCol; j++){
                tmp.add("Empty");
            }
            this.cases.add(tmp);
        }
    }

    public Grille(){
        this.nbLig = 0;
        this.nbCol = 0;
        this.ligSeqs = new ArrayList<ArrayList<Integer>>();
        this.colSeqs = new ArrayList<ArrayList<Integer>>();
        this.cases = new ArrayList<ArrayList<String>>();
    }

    public int getNbLig(){
        return this.nbLig;
    }

    public int getNbCol(){
        return this.nbCol;
    }

    public ArrayList<ArrayList<Integer>> getLigSeqs(){
        return this.ligSeqs;
    }

    public ArrayList<ArrayList<Integer>> getColSeqs(){
        return this.colSeqs;
    }

    public ArrayList<ArrayList<String>> getCases(){
        return this.cases;
    }

    public void setCases(ArrayList<ArrayList<String>> cases){
        this.cases = cases;
    }

    public void setCase(int i, int j, String color){
        this.cases.get(i).set(j, color);
    }

    public String getCase(int i, int j){
        return this.cases.get(i).get(j);
    }

    public boolean isColored(int i, int j){
        return !this.getCase(i, j).equals("Empty");
    }

    public ArrayList<String> getLigne(int i){
        return this.cases.get(i);
    }

    public ArrayList<String> getColonne(int j){
        ArrayList<String> tmp = new ArrayList<String>();
        for(int i = 0; i < this.nbLig; i++){
            tmp.add(this.getCase(i, j));
        }
        return tmp;
    }

    public void setLigne(int i, ArrayList<String> ligne){
        this.cases.set(i, ligne);
    }

    public void setColonne(int j, ArrayList<String> colonne){
        for(int i = 0; i < this.nbLig; i++){
            this.setCase(i, j, colonne.get(i));
        }
    }

    public Grille clone() {
        try {
            Grille cloned = (Grille) super.clone();

            // 深拷贝 ligSeqs
            cloned.ligSeqs = new ArrayList<>();
            for (ArrayList<Integer> seq : this.ligSeqs) {
                cloned.ligSeqs.add(new ArrayList<>(seq));
            }

            // 深拷贝 colSeqs
            cloned.colSeqs = new ArrayList<>();
            for (ArrayList<Integer> seq : this.colSeqs) {
                cloned.colSeqs.add(new ArrayList<>(seq));
            }

            // 深拷贝 cases
            cloned.cases = new ArrayList<>();
            for (ArrayList<String> row : this.cases) {
                cloned.cases.add(new ArrayList<>(row));
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // 不应该发生，因为我们支持克隆
        }
    }

    public String toString(){
        String res = "";
        for(int i = 0; i < this.nbLig; i++){
            for(int j = 0; j < this.nbCol; j++){
                res += this.getCase(i, j) + " ";
            }
            res += "\n";
        }
        return res;
    }

 



}
