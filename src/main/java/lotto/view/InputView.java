package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoInputDto;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final int lottoPrice = 1000;
    private final String INVALID_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    public LottoInputDto enterInput() {
        long purchaseAmount = enterPurchaseAmount();
        List<Integer> winningNumber = enterWinningNumber();
        int bonusNumber = enterBonusNumber();

        return new LottoInputDto(purchaseAmount, winningNumber, bonusNumber);
    }

    private long enterPurchaseAmount() {
        long purchaseAmount = Long.parseLong(Console.readLine());
        validatePurchaseAmountDividedBy1000(purchaseAmount);
        return purchaseAmount;
    }

    private List<Integer> enterWinningNumber() {
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private int enterBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private void validatePurchaseAmountDividedBy1000(long purchaseAmount) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }
}
