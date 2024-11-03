package lotto;


import lotto.io.Input;
import lotto.io.View;


public class Application {
    private final LottoGenerator lottoGenerator;
    private final LottoResult lottoResult;
    private final WinningChecker winningChecker;
    private final Integer price;

    public Application() {
        Input input = new Input();
        this.price = input.getPrice();
        this.lottoGenerator = new LottoGenerator();
        this.lottoResult = new LottoResult();
        this.winningChecker = new WinningChecker(input.getWinningNumber(), input.getBonusNumber(), lottoResult);
    }

    public static void main(String[] args) {
        Application lottoMachine = new Application();

        LottoGenerator lottoGenerator = lottoMachine.getLottoGenerator();
        LottoResult lottoResult = lottoMachine.getLottoResult();

        Lottos lottos = lottoGenerator.generateLottos(lottoMachine.getPrice());

        WinningChecker winningChecker = lottoMachine.getWinningChecker();
        winningChecker.calculate(lottos);

        printIssuedLottos(lottos);
        printResult(lottos, lottoResult);
    }

    private static void printIssuedLottos(Lottos lottos) {
        View.printLotto(lottos.getLottoCount(), lottos.toString());
    }

    private static void printResult(Lottos lottos, LottoResult lottoResult) {
        View.printWinningResult(lottoResult.toString());
        View.printProfit(lottoResult.getProfitRate(lottos));
    }

    public Integer getPrice() {
        return price;
    }

    private LottoResult getLottoResult() {
        return lottoResult;
    }

    private LottoGenerator getLottoGenerator() {
        return lottoGenerator;
    }

    private WinningChecker getWinningChecker() {
        return winningChecker;
    }

}
