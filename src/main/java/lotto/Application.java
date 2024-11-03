package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputView lottoInputView = new LottoInputView();
        LottoService lottoService = new LottoService();
        LottoOutputView lottoOutputView = new LottoOutputView();

        LottoGameController game = new LottoGameController(lottoInputView, lottoService, lottoOutputView);
        game.play();

    }
}
