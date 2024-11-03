package lotto;

public class Application {

    public static void main(String[] args) {
        LottoResult lottoResult = new LottoResult(new InputView(), new OutputView());
        lottoResult.start();
    }
}
