package lotto;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = LottoManager.getInstance();
        lottoManager.run();
    }
}
