package lotto;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoController lottoController = new LottoController(lottoView, lottoMachine);
        lottoController.run();
    }
}
