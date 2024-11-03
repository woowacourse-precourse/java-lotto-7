package lotto;


import lotto.config.Container;
import lotto.config.LottoConfig;
import lotto.domain.*;
import lotto.io.Input;
import lotto.io.View;
import lotto.service.LottoGenerator;
import lotto.service.ProfitCalculator;
import lotto.service.WinningChecker;


public class Application {

    public static void main(String[] args) {
        LottoConfig.configure();

        Money price = Container.getInstance(Money.class);
        WinningNumber winningNumber = Container.getInstance(WinningNumber.class);
        BonusNumber bonusNumber = Container.getInstance(BonusNumber.class);

        LottoGenerator lottoGenerator = Container.getInstance(LottoGenerator.class);
        WinningChecker winningChecker = Container.getInstance(WinningChecker.class);
        Lottos lottos = lottoGenerator.generateLottos(price.getAmount());

        winningChecker.calculate(lottos, winningNumber, bonusNumber);

        ProfitCalculator profitCalculator = Container.getInstance(ProfitCalculator.class);
        Double profitRate = profitCalculator.getProfitRate(lottos);
        LottoResult lottoResult = Container.getInstance(LottoResult.class);

        View.printLotto(lottos.getLottoCount(), lottos.toString());
        View.printWinningResult(lottoResult.toString());
        View.printProfit(profitRate);

        Container.reset();
    }

}
