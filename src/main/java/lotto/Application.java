package lotto;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoFactory.createLottoController();
        lottoController.run();
    }
}
