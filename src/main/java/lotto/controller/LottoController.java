package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoRule;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;
import lotto.service.LottoMatcher;
import lotto.service.ProfitCalculator;
import lotto.view.UserInput;

public class LottoController {
    private final UserInput userInput;
    private final LottoGenerator lottoGenerator;
    private final LottoMatcher lottoMatcher;
    private final ProfitCalculator profitCalculator;

    public LottoController() {
        this.userInput = new UserInput();
        this.lottoGenerator = new LottoGenerator();
        this.lottoMatcher = new LottoMatcher();
        this.profitCalculator = new ProfitCalculator();
    }

    public void process() {
        int amount = userInput.getPurchaseAmount();

        Lottos lottos = lottoGenerator.getnerateLottos(amount);
        System.out.println(lottos.getSize() + "개를 구매했습니다.");

        lottos.getLottos().forEach(lotto -> System.out.println(lotto));

        List<Integer> winNumbers = userInput.inputWinNumbers();
        int bonusNumber = userInput.inputBonusNumber(winNumbers);

        Map<LottoRule, Integer> matchedLotto = lottoMatcher.calculateMatch(lottos, winNumbers, bonusNumber);

        double profitRate = profitCalculator.calculateProfitRate(matchedLotto,amount);
    }
}
