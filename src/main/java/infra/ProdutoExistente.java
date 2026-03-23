package infra;

public class ProdutoExistente extends RuntimeException {
    public ProdutoExistente(String message) {
        super(message);
    }
}
