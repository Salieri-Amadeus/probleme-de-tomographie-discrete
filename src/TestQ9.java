public class TestQ9 {
    public static void main(String[] args){
        try{
            Grille g = Util.fileToGrille("src/instances/0.txt");
            long startTime = System.nanoTime();
            ColoreResult res = Util.coloration(g);
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
