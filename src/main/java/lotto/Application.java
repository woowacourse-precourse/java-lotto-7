package lotto;


import lotto.config.Container;
import lotto.config.LottoConfig;
import lotto.domain.Lottos;
import lotto.io.Input;
import lotto.io.View;
import lotto.service.LottoGenerator;
import lotto.service.LottoResult;
import lotto.service.WinningChecker;


public class Application {

    public static void main(String[] args) {
        LottoConfig.configure();

        Input input = Container.getInstance(Input.class);
        LottoGenerator lottoGenerator = Container.getInstance(LottoGenerator.class);
        LottoResult lottoResult = Container.getInstance(LottoResult.class);
        WinningChecker winningChecker = Container.getInstance(WinningChecker.class);

        Lottos lottos = lottoGenerator.generateLottos(input.getPrice());
        winningChecker.calculate(lottos);

        printIssuedLottos(lottos);
        printResult(lottos, lottoResult);

        Container.reset();
    }

    private static void printIssuedLottos(Lottos lottos) {
        View.printLotto(lottos.getLottoCount(), lottos.toString());
    }

    private static void printResult(Lottos lottos, LottoResult lottoResult) {
        View.printWinningResult(lottoResult.toString());
        View.printProfit(lottoResult.getProfitRate(lottos));
    }

}
