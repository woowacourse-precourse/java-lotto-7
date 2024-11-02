package lotto;

import java.util.List;

public class LottoOutput {
    private final static String PURCHASE_AMOUNT_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public void displayPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT_MESSAGE);
    }

    public void displayPurchasedLottoCount(long purchasedLottoCount) {
        System.out.println(purchasedLottoCount + PURCHASED_LOTTO_COUNT_MESSAGE);
    }

    public void displayLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}