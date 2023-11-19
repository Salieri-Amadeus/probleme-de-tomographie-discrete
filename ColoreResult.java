public class ColoreResult {
    private String success;
    private Grille updatedGrille;

    public ColoreResult(String success, Grille updatedGrille) {
        this.success = success;
        this.updatedGrille = updatedGrille;
    }

    public String getSuccess() {
        return success;
    }

    public Grille getUpdatedGrille() {
        return updatedGrille;
    }
}
