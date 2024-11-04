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

    private void printStatistics(Map<LottoRule, Integer> statistics, int amount) {
        System.out.println("당첨 통계\n---");
        int totalPrize = 0;

        for (LottoRule rule : LottoRule.values()) {
            int count = statistics.getOrDefault(rule, 0);
            System.out.printf("%s - %d개\n", rule.getInfo(), count);
            totalPrize += count * rule.getPrize();
        }

        double profitRate = (double) totalPrize / amount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
