public class TestQ13 {
    public static void main(String[] args){
        try{
            Grille g = Util.fileToGrille("instances/15.txt");
            long startTime = System.nanoTime();
            ColoreResult res = Util.enumeration(g);
            long endTime = System.nanoTime();
            System.out.println("Took "+(endTime - startTime) + " ns");
            System.out.println(res.getSuccess());
            System.out.println(res.getUpdatedGrille());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
