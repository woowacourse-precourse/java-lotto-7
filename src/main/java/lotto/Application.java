package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoView lottoView = new LottoView();
        lotto.controller.LottoController lottoController = new lotto.controller.LottoController(lottoView);

        lottoController.start();

    }
}
