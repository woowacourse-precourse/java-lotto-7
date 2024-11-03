package lotto.validator;

import java.util.List;

public class LottoMachineValidator {

    public static void validate(int paymentAmount, List<Integer> winningMainNumbers) {
        if (winningMainNumbers == null || winningMainNumbers.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 없습니다.");
        }
        PurchaseValidator.validate(paymentAmount);
    }

}
