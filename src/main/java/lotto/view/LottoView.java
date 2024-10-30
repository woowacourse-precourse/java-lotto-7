package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoExceptionHandler;

public class LottoView {
    public int inputPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int lottoAmount = Integer.parseInt(Console.readLine());
            LottoExceptionHandler.validatePurchase(lottoAmount);
            return lottoAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }
}
