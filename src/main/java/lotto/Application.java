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
        initializeConfiguration();

        Money price = Container.getInstance(Money.class);
        WinningNumber winningNumber = Container.getInstance(WinningNumber.class);
        BonusNumber bonusNumber = Container.getInstance(BonusNumber.class);

        Lottos lottos = generateLottos(price);
        calculateWinningResults(lottos, winningNumber, bonusNumber);

        displayResults(lottos);

        Container.reset();
    }

    private static void initializeConfiguration() {
        LottoConfig.registerInputDependencies();
        LottoConfig.registerCoreServices();
    }

    private static Lottos generateLottos(Money price) {
        LottoGenerator lottoGenerator = Container.getInstance(LottoGenerator.class);
        return lottoGenerator.generateLottos(price.getAmount());
    }

    private static void calculateWinningResults(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningChecker winningChecker = Container.getInstance(WinningChecker.class);
        winningChecker.calculate(lottos, winningNumber, bonusNumber);
    }

    private static void displayResults(Lottos lottos) {
        ProfitCalculator profitCalculator = Container.getInstance(ProfitCalculator.class);
        Double profitRate = profitCalculator.getProfitRate(lottos);
        LottoResult lottoResult = Container.getInstance(LottoResult.class);

        View.printLotto(lottos.getLottoCount(), lottos.toString());
        View.printWinningResult(lottoResult.toString());
        View.printProfit(profitRate);
    }

}
