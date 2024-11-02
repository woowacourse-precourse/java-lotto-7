package lotto;

import enums.InputRegix;

public class LottoService {

    public int getNumberOfTickets(String purchase) {
        if (!purchase.matches(InputRegix.PURCHASE.getRegix())) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 숫자여야 합니다.");
        }

        return Integer.parseInt(purchase) / 1000;
    }
}
