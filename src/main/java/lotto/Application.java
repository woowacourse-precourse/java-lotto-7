package lotto;

public class Application {
    public static void main(String[] args) {

        LottoModel lottoModel = new LottoModel();
        LottoView lottoView = new LottoView(lottoModel);

        LottoController lottoController = new LottoController(lottoView, lottoModel);
        lottoController.run();
    }
}
