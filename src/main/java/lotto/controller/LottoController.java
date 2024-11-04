package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoRule;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;
import lotto.service.LottoMatcher;
import lotto.service.ProfitCalculator;
import lotto.view.Output;
import lotto.view.UserInput;

public class LottoController {
    private final UserInput userInput;
    private final LottoGenerator lottoGenerator;
    private final LottoMatcher lottoMatcher;
    private final ProfitCalculator profitCalculator;
    private final Output output;

    public LottoController() {
        this.userInput = new UserInput();
        this.lottoGenerator = new LottoGenerator();
        this.lottoMatcher = new LottoMatcher();
        this.profitCalculator = new ProfitCalculator();
        this.output = new Output();
    }

    public void process() {
        output.printPurchaseAmount();
        int amount = userInput.getPurchaseAmount();

        Lottos lottos = lottoGenerator.getnerateLottos(amount);
        output.printPurchaseResult(lottos);

        output.printWinNumbers();
        List<Integer> winNumbers = userInput.inputWinNumbers();

        output.printBonusNumber();
        int bonusNumber = userInput.inputBonusNumber(winNumbers);

        Map<LottoRule, Integer> matchedLotto = lottoMatcher.calculateMatch(lottos, winNumbers, bonusNumber);

        double profitRate = profitCalculator.calculateProfitRate(matchedLotto,amount);

        output.printMatchedLottoResult(matchedLotto);
        output.printProfitRate(profitRate);
    }
}
