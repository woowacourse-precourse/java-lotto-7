package lotto.view;

import java.util.Map;
import lotto.model.LottoRule;
import lotto.model.Lottos;

public class Output {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String MATCHED_LOTTO_RESULT_HEADER = "당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseResult(Lottos lottos) {
        System.out.println(lottos.getSize() + PURCHASE_RESULT_MESSAGE);
        lottos.getLottos().forEach(lotto -> System.out.println(lotto));
    }

    public void printWinNumbers() {
        System.out.println(WIN_NUMBERS_MESSAGE);
    }

    public void printBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }


    public void printMatchedLottoResult(Map<LottoRule, Integer> matchedLotto) {
        System.out.println(MATCHED_LOTTO_RESULT_HEADER);

        for (LottoRule rule : LottoRule.values()) {
            int count = matchedLotto.getOrDefault(rule, 0);
            System.out.printf("%s - %d개\n", rule.getInfo(), count);
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
