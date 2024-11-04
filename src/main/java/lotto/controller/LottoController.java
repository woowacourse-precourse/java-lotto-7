package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.LottoRule;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;
import lotto.view.UserInput;

public class LottoController {
    private final UserInput userInput;
    private final LottoGenerator lottoGenerator;

    public LottoController() {
        this.userInput = new UserInput();
        this.lottoGenerator = new LottoGenerator();
    }

    public void process() {
        int amount = userInput.getPurchaseAmount();

        Lottos lottos = lottoGenerator.getnerateLottos(amount);
        System.out.println(lottos.getSize() + "개를 구매했습니다.");

        lottos.getLottos().forEach(lotto -> System.out.println(lotto));

        List<Integer> winNumbers = userInput.inputWinNumbers();
        int bonusNumber = userInput.inputBonusNumber(winNumbers);

        Map<LottoRule, Integer> statistics = lottos.calculateMatch(winNumbers, bonusNumber);

        printStatistics(statistics, amount);
    }

    private void printStatistics(Map<LottoRule, Integer> statistics, int amount) {
        System.out.println("당첨 통계\n---");
        int totalPrize = 0;

        for (LottoRule rule : LottoRule.values()) {
            int count = statistics.getOrDefault(rule, 0);
            System.out.printf("%s - %d개\n", rule.getInfo(), count);
            totalPrize += count * rule.getPrize();
        }
    }
}
