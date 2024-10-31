package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE_INSUFFICIENT_MESSAGE = "구입금액이 부족합니다. 구매 개수를 낮춰주세요.";
    private static final String REQUEST_UNIT_OF_1000_MESSAGE = LOTTO_PRICE + "원 단위로 입력해주세요.";

    private final Amount inputAmount;

    public Lotto(int amount) {
        validateAmount(amount);
        this.inputAmount = new Amount(amount);
    }

    private void validateAmount(int amount) {
        if (isNotDivisibleLottoPrice(amount)) {
            throw new IllegalArgumentException(PURCHASE_INSUFFICIENT_MESSAGE);
        }
    }

    private boolean isNotDivisibleLottoPrice(int amount) {
        return amount % LOTTO_PRICE != 0;
    }


    public void validateTicketCount(int ticketCount) {
        if (!isPurchasable(ticketCount)) {
            throw new IllegalArgumentException(REQUEST_UNIT_OF_1000_MESSAGE);
        }
    }

    private boolean isPurchasable(int ticketCount) {
        return ticketCount <= inputAmount.getAmountDivide(LOTTO_PRICE);
    }

    // TODO: 추가 기능 구현
}
