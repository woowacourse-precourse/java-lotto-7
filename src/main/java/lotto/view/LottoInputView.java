package lotto.view;

import lotto.util.InputUtil;

public class LottoInputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmountInput() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return InputUtil.readInput();
    }

    public String readLottoNumberInput() {
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
        return InputUtil.readInput();
    }

    public String readBonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return InputUtil.readInput();
    }
}
