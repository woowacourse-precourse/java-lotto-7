package lotto;


import lotto.config.Container;
import lotto.config.LottoConfig;
import lotto.domain.Lottos;
import lotto.io.Input;
import lotto.io.View;
import lotto.service.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.service.ProfitCalculator;
import lotto.service.WinningChecker;


public class Application {

    public static void main(String[] args) {
        LottoConfig.configure();

        LottoGenerator lottoGenerator = Container.getInstance(LottoGenerator.class);
        LottoResult lottoResult = Container.getInstance(LottoResult.class);
        ProfitCalculator profitCalculator = Container.getInstance(ProfitCalculator.class);
        WinningChecker winningChecker = Container.getInstance(WinningChecker.class);

        Lottos lottos = lottoGenerator.generateLottos();
        winningChecker.calculate(lottos);
        Double profitRate = profitCalculator.getProfitRate(lottos);

        View.printLotto(lottos.getLottoCount(), lottos.toString());
        View.printWinningResult(lottoResult.toString());
        View.printProfit(profitRate);

        Container.reset();
    }

}
