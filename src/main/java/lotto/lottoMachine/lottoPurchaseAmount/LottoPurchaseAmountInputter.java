package lotto.lottoMachine.lottoPurchaseAmount;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchaseAmountInputter {
    private static final String NOTICE_TO_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public String getInput() {
        noticeInputPurchaseAmount();
        String lottoPurchaseAmount = extractInputLottoPurchaseAmount();

        return lottoPurchaseAmount;
    }

    private String extractInputLottoPurchaseAmount() {
        String lottoPurchaseAmount = Console.readLine();

        return lottoPurchaseAmount;
    }

    private void noticeInputPurchaseAmount() {
        System.out.println(NOTICE_TO_INPUT_PURCHASE_AMOUNT);
    }
}
