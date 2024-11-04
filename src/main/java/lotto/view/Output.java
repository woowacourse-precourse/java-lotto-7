package lotto.view;

import java.util.Map;
import lotto.model.LottoRule;
import lotto.model.Lottos;

public class Output {

    public void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseResult(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        lottos.getLottos().forEach(lotto -> System.out.println(lotto));
    }

    public void printWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    public void printMatchedLottoResult(Map<LottoRule, Integer> matchedLotto) {
        System.out.println("당첨 통계\n---");

        for (LottoRule rule : LottoRule.values()) {
            int count = matchedLotto.getOrDefault(rule, 0);
            System.out.printf("%s - %d개\n", rule.getInfo(), count);
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
