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
        int amount = getValidAmount();
        Lottos lottos = lottoGenerator.getnerateLottos(amount);
        output.printPurchaseResult(lottos);

        List<Integer> winNumbers = getValidWinNumbers();
        int bonusNumber = getValidBonusNumber(winNumbers);

        Map<LottoRule, Integer> matchedLotto = lottoMatcher.calculateMatchResult(lottos, winNumbers, bonusNumber);
        double profitRate = profitCalculator.calculateProfitRate(matchedLotto, amount);

        output.printMatchedLottoResult(matchedLotto);
        output.printProfitRate(profitRate);
    }

    private int getValidAmount() {
        while (true) {
            try {
                output.printPurchaseAmount();
                return userInput.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinNumbers() {
        while (true) {
            try {
                output.printWinNumbers();
                return userInput.inputWinNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winNumbers) {
        while (true) {
            try {
                output.printBonusNumber();
                return userInput.inputBonusNumber(winNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
