package lotto.common.controller.handler;

import lotto.common.controller.formatter.StringFormatter;
import lotto.lotto.domain.LottoResults;
import lotto.purchase.domain.PurchaseResult;

public class ConsoleOutputHandler {

    private static final String MONEY_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_BUYING_PROMPT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_NUMBER_PROMPT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_PROMPT_MESSAGE = "당첨 통계\n---";

    private final StringFormatter stringFormatter;

    public ConsoleOutputHandler(StringFormatter stringFormatter) {
        this.stringFormatter = stringFormatter;
    }

    public void printMoneyPromptMessage() {
        System.out.println(MONEY_PROMPT_MESSAGE);
    }

    public void printGeneratedLottos(LottoResults lottoResults) {
        String lottos = stringFormatter.lottoNumberFormatter(lottoResults);
        System.out.println(lottos);
    }

    public void printBuyingLottoMessage(long amount) {
        System.out.println(amount + LOTTO_BUYING_PROMPT_MESSAGE);
    }

    public void printWinningLottoMessage() {
        System.out.println();
        System.out.println(LOTTO_NUMBER_PROMPT_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_PROMPT_MESSAGE);
    }

    public void printResultMessage(PurchaseResult purchaseResult) {
        System.out.println();
        System.out.println(RESULT_PROMPT_MESSAGE);
        System.out.print(stringFormatter.lottoWinningInfoFormatter(purchaseResult));
        System.out.println(stringFormatter.rateInfoFormatter(purchaseResult));
    }


}
