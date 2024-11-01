package lotto.common.view;

import static lotto.common.constant.PromptMessage.*;

public class OutputView {

    private static final String messageOfNumberOfLottoSuffix = "개를 구매했습니다.";
    private static final String unit = "개";
    private static final String messageOfRateOfReturnPrefix = "총 수익률은 ";
    private static final String messageOfRateOfReturnSuffix = "%입니다.";

    public static void printPromptMessageForPriceToBuyLotto() {
        System.out.println(PROMPT_MESSAGE_FOR_PRICE_TO_BUY_LOTTO.getPromptMessage());
    }

    public static void printNumberOfLotto(final Integer numberOfLotto) {
        System.out.println(numberOfLotto + messageOfNumberOfLottoSuffix);
    }

}
