package lotto;


public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoFactory lottoMachine = new LottoFactory(new RandomNumberGenerator());

        User user = inputView.createUser();
        Lottos lottos = lottoMachine.createLottos(user.getMoney());
        outputView.printBoughtLottos(lottos.getLottos());

        WinningLotto winningLotto = inputView.createWinningLotto();
        outputView.printLottoResult(lottos, winningLotto);
    }
}